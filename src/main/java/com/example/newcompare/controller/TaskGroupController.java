package com.example.newcompare.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.newcompare.common.utils.Result;
import com.example.newcompare.common.utils.ZipUntils;
import com.example.newcompare.entity.OrderLog;
import com.example.newcompare.entity.TaskGroup;
import com.example.newcompare.service.FileService;
import com.example.newcompare.service.TaskGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@Api(value = "taskGroup")
@RequestMapping("/taskGroup")
public class TaskGroupController {

    @Autowired
    FileService fileService;

    @Autowired
    TaskGroupService service;

    @PostMapping("/create")
    @ApiOperation("刘锦堂===》创建新的group")
    public Result create(@RequestBody TaskGroup group) {
        group.setName(group.getName());
        group.setCreateTime(LocalDateTime.now());
        Integer i = service.create(group);
        if (i == 0) {
            return Result.fail("插入失败");
        }
        return Result.success("插入成功");
    }

    @PostMapping("/getGroups")
    @ApiOperation(value = "郑前===》获取历史记录,keywords: 任务组名字or订单流水号or订单id" +
            "maxPage: 每页显示最大数量，" +
            "startPage: 开始页码,startTime和endTime: 要查询的时间段"+
            "sort:排序方式，默认升序排列")
    public Result getGroups(@RequestBody Map<String, String> map) {
        //最大显示数量默认是10
        int maxPage = 10;
        //起始页码默认为是1
        int startPage = 1;
        //排序方式默认升序
        String defaultSort ="asc";

        String mPage = map.get("maxPage");
        String sPage = map.get("startPage");
        String keyWords = map.get("keyWords");
        String startTime = map.get("startTime");
        String endTime = map.get("endTime");
        String sort=map.get("sort");

        if (sPage != null) {
            startPage = Integer.parseInt(sPage);
        }
        if (mPage != null) {
            maxPage = Integer.parseInt(mPage);
        }
        if (sort != null) {
            defaultSort = sort;
        }
        Page<TaskGroup> Page = new Page<>(startPage, maxPage,  service.getTotal(keyWords, startTime, endTime).size(),false);
        Page<TaskGroup> groups = service.getGroups(Page, keyWords, startTime, endTime, defaultSort);
        long total= groups.getTotal();
        long pages=total%maxPage==0?total/maxPage:total/maxPage+1;
        int start = (startPage-1)*(maxPage);
        List<TaskGroup> list = new ArrayList<>(maxPage);
        for(int i=0;i<groups.getRecords().size();i++){
            list.add(groups.getRecords().get(i));
        }
        for (TaskGroup taskGroup : list) {
            if (taskGroup.getOrders().get(0).getId()==null){
                taskGroup.setOrders(null);
            }
        }
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("total",total);
        map1.put("pages",pages);
        map1.put("current",startPage);
        map1.put("records",list);
        map1.put("size",maxPage);

        return Result.success(map1);
    }

    @GetMapping("/getGroupById")
    @ApiOperation(value = "郑前===》获取单个任务组")
    public Result getGroupById(String groupId) {
        //最大显示数量默认是10
        int maxPage = 10;
        //起始页码默认为是1
        int startPage = 1;
        Page<OrderLog> Page = new Page(startPage, maxPage);
        return Result.success(service.getGroupById(Page, groupId));
    }

    @ApiOperation("左呈祥===》批量删除group")
    @DeleteMapping("/delete")
    public Result deleteGroups(@RequestBody ArrayList<Integer> groupIds) {
        return service.remove(new LambdaQueryWrapper<TaskGroup>().in(TaskGroup::getId,groupIds)) ? Result.success(200,"删除成功","") : Result.fail(404,"删除失败","");


    }




    /**
     * @return 文件
     */
    @ApiOperation("肖恒宇====>多文件下载")
    @GetMapping("/download")
    public void fileDownload(Integer[] ids, HttpServletResponse response) throws Exception {
        List<TaskGroup> allSendIdFromTask = service.getAllIdFromTask(ids);

        List<OrderLog> aLlIdByTask = service.getALlIdByTask(allSendIdFromTask);
        String path = "/tmp/template/"+UUID.randomUUID();
        boolean iu = service.backZip(aLlIdByTask,path);

        //  response.setContentType("application/octet-stream");

        if (iu == true) {
            //读，写
            FileInputStream in = null;

            ServletOutputStream out = null;
            try {
                in = new FileInputStream(path+".zip");
                out = response.getOutputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            } catch (Exception o) {
                o.printStackTrace();
            } finally {

                in.close();
                out.close();

            }

            //* return Result.success();*//*

        }


        ZipUntils.deleteDir(path);
        new File(path+".zip").delete();



        /*  return Result.fail("下载失败");*/
    }




}
