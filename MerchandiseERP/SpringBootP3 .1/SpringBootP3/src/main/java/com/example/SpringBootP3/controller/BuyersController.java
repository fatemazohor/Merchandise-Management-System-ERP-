package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.buyer.*;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.model.sale.Size;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.repository.buyer.*;
import com.example.SpringBootP3.repository.sale.IStyle;
import com.example.SpringBootP3.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Time;
import java.util.List;

@Controller
public class BuyersController {
    @Autowired
    private IBuyerRepo buyerRepo;
    @Autowired
    private IOrderStatus orderStatusRepo;
    @Autowired
    private IOrderDetails orderDetailsRepo;
    @Autowired
    private IStyle styleRepo;
    @Autowired
    private ITask taskRepo;
    @Autowired
    private ITimeActionRepo timeActionRepo;
    @Autowired
    private InventoryService inventoryService;



    //buyers registration
    @GetMapping("/buyers/list")
    public String buyersList(Model m){
        List<Buyers> buyersList=buyerRepo.findAll();
        m.addAttribute("title","Buyers List");
        m.addAttribute("buyersList", buyersList);
        return "buyers/buyersList";
    }
    @GetMapping("/buyers/addform")
    public String buyersform(Model m){


        m.addAttribute("buyers",new Buyers());
        m.addAttribute("title","Create new Buyers");
        return "buyers/buyersForm";
    }

    @PostMapping("/buyers/save")
    public String buyersSave(@ModelAttribute Buyers buyers){
        buyerRepo.save(buyers);
        return "redirect:/buyers/list";
    }
    @GetMapping("/buyers/delete/{id}")
    public String buyersDelete(@PathVariable int id){
        buyerRepo.deleteById(id);
        return "redirect:/buyers/list";
    }

    @GetMapping("/buyers_edit/{id}")
    public String buyersEdit(@PathVariable int id,Model m){
        Buyers buyersname=buyerRepo.findById(id).get();
        m.addAttribute("title","Update Buyers");
        m.addAttribute("buyers",buyersname);
        return "buyers/buyersForm";

    }
    //buyers registration end
    //Order Status start
    @GetMapping("/order_status/list")
    public String orderStatusList(Model m){
        List<OrderStatus> orderStatusList=orderStatusRepo.findAll();
        m.addAttribute("title","Order Status List");
        m.addAttribute("orderStatusList", orderStatusList);
        return "buyers/orderStatusList";
    }
    @GetMapping("/order_status/addform")
    public String orderStatusform(Model m){


        m.addAttribute("orderStatus",new OrderStatus());
        m.addAttribute("title","Create new Order Status");
        return "buyers/orderStatusForm";
    }

    @PostMapping("/order_status/save")
    public String orderStatusSave(@ModelAttribute OrderStatus orderStatus){
        orderStatusRepo.save(orderStatus);
        return "redirect:/order_status/list";
    }
    @GetMapping("/order_status/delete/{id}")
    public String orderStatusDelete(@PathVariable int id){
        orderStatusRepo.deleteById(id);
        return "redirect:/order_status/list";
    }

    @GetMapping("/order_status_edit/{id}")
    public String orderStatusEdit(@PathVariable int id,Model m){
        OrderStatus orderStatusname=orderStatusRepo.findById(id).get();
        m.addAttribute("title","Update Order Status");
        m.addAttribute("orderStatus",orderStatusname);
        return "buyers/orderStatusForm";

    }
    //Order Status end

    //Order Details

    @GetMapping("/order_details/list")
    public String orderdetailsList(Model m){
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("title","Order Details List");
        m.addAttribute("orderDetailsList", orderDetailsList);
        return "buyers/orderDetailsList";
    }
    @GetMapping("/order_details/addform")
    public String orderDetailsform(Model m){

        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

        //Buyer id dropdown
        List<Buyers> buyersList=buyerRepo.findAll();
        m.addAttribute("buyersList", buyersList);
        //Order Status dropdown
        List<OrderStatus> orderStatusList=orderStatusRepo.findAll();
        m.addAttribute("orderStatusList", orderStatusList);


        m.addAttribute("orderDetails",new OrderDetails());
        m.addAttribute("title","Create new Order Details");
        return "buyers/orderDetailsForm";
    }

    @PostMapping("/order_details/save")
    public String orderDetailsSave(@ModelAttribute OrderDetails orderDetails){
        orderDetailsRepo.save(orderDetails);
        return "redirect:/order_details/list";
    }
    @GetMapping("/order_details/delete/{id}")
    public String orderDetailsDelete(@PathVariable int id){
        orderDetailsRepo.deleteById(id);
        return "redirect:/order_details/list";
    }

    @GetMapping("/order_details_edit/{id}")
    public String orderDetailsEdit(@PathVariable int id,Model m){

        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

        //Buyer id dropdown
        List<Buyers> buyersList=buyerRepo.findAll();
        m.addAttribute("buyersList", buyersList);

        //Order Status dropdown
        List<OrderStatus> orderStatusList=orderStatusRepo.findAll();
        m.addAttribute("orderStatusList", orderStatusList);

        OrderDetails orderDetailsname=orderDetailsRepo.findById(id).get();
        m.addAttribute("title","Update Order Details");
        m.addAttribute("orderDetails",orderDetailsname);
        return "buyers/orderDetailsUpdateForm";

    }



    //Order Details end

    //Task Start
    @GetMapping("/task/list")
    public String taskList(Model m){
        List<Task> taskList=taskRepo.findAll();
        m.addAttribute("title","Task List");
        m.addAttribute("taskList", taskList);
        return "buyers/taskList";
    }
    @GetMapping("/task/addform")
    public String taskform(Model m){


        m.addAttribute("task",new Task());
        m.addAttribute("title","Create new Task");
        return "buyers/taskForm";
    }

    @PostMapping("/task/save")
    public String taskSave(@ModelAttribute Task task){
        taskRepo.save(task);
        return "redirect:/task/list";
    }
    @GetMapping("/task/delete/{id}")
    public String taskDelete(@PathVariable int id){
        taskRepo.deleteById(id);
        return "redirect:/task/list";
    }

    @GetMapping("/task_edit/{id}")
    public String taskEdit(@PathVariable int id,Model m){
        Task taskname=taskRepo.findById(id).get();
        m.addAttribute("title","Update Task");
        m.addAttribute("task",taskname);
        return "buyers/taskForm";

    }
    //Task end


    //TimeAction start
    //pagination

    @GetMapping("/tpage/{tpageNo}")
    public String findTPaginated(@PathVariable("tpageNo")int pageNo,Model m){
        int pageSize=8;
        Page<TimeAction> page=inventoryService.findTimePaginated(pageNo,pageSize);

        List<TimeAction> timeActionList = page.getContent();
        m.addAttribute("currentPage",pageNo);
        m.addAttribute("totalPages",page.getTotalPages());
        m.addAttribute("totalItems",page.getTotalElements());
        m.addAttribute("timeActionList",timeActionList);
        m.addAttribute("title","Time Action List");
        return "buyers/timeActionList";
    }

    //pagination end
    @GetMapping("/time_action/list")
    public String timeActionList(Model m){
//        List<TimeAction> timeActionList=timeActionRepo.findAll();
//        m.addAttribute("title","Time Action List");
//        m.addAttribute("timeActionList", timeActionList);
        return findTPaginated(1,m);
    }
    @GetMapping("/time_action/addform")
    public String timeActionform(Model m){
        // Order Id dropdown
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("orderDetailsList", orderDetailsList);
        //task id dropdown
        List<Task> taskList=taskRepo.findAll();
        m.addAttribute("taskList", taskList);



        m.addAttribute("timeAction",new TimeAction());
        m.addAttribute("title","Create new Time Action");
        return "buyers/timeActionForm";
    }

    @PostMapping("/time_action/save")
    public String timeActionSave(@ModelAttribute TimeAction timeAction){
        timeActionRepo.save(timeAction);
        return "redirect:/time_action/list";
    }
    @GetMapping("/time_action/delete/{id}")
    public String timeActionDelete(@PathVariable int id){
        timeActionRepo.deleteById(id);
        return "redirect:/time_action/list";
    }

    @GetMapping("/time_action_edit/{id}")
    public String timeActionEdit(@PathVariable int id,Model m){

        // Order Id dropdown
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("orderDetailsList", orderDetailsList);
        //task id dropdown
        List<Task> taskList=taskRepo.findAll();
        m.addAttribute("taskList", taskList);

        TimeAction timeActionname=timeActionRepo.findById(id).get();
        m.addAttribute("title","Update Time Action");
        m.addAttribute("timeAction",timeActionname);
        return "buyers/timeActionForm";

    }

    //TimeAction end
}
