package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.bom.Department;
import com.example.SpringBootP3.model.bom.LaborCost;
import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.repository.bom.IDepartmentRepo;
import com.example.SpringBootP3.repository.bom.ILaborCost;
import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.repository.sale.IStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MaterialBillController {

    @Autowired
    private IDepartmentRepo departmentRepo;
    @Autowired
    private ILaborCost laborCostRepo;

    @Autowired
    private IStyle iStylerepo;

    @Autowired
    private IOrderDetails orderDetailsRepo;

    //department start

    @GetMapping("/department/list")
    public String departmentList(Model m){
        List<Department> departmentList=departmentRepo.findAll();
        m.addAttribute("title","Department List");
        m.addAttribute("departmentList", departmentList);
        return "bill/departmentList";
    }
    @GetMapping("/department/addform")
    public String departmentform(Model m){
        m.addAttribute("department",new Department());
        m.addAttribute("title","Create New Department");
        return "bill/departmentForm";
    }
    @PostMapping("/department/save")
    public String departmentSave(@ModelAttribute Department department){
        departmentRepo.save(department);
        return "redirect:/department/list";
    }
    @GetMapping("/department/delete/{id}")
    public String departmentDelete(@PathVariable int id){
        departmentRepo.deleteById(id);
        return "redirect:/department/list";
    }

    @GetMapping("/department_edit/{id}")
    public String departmentEdit(@PathVariable int id,Model m){
        Department deptName=departmentRepo.findById(id).get();
        m.addAttribute("title","Update Department");
        m.addAttribute("department",deptName);
        return "bill/departmentForm";

    }

    //department end
    //Labor cost start

    @GetMapping("/labor_cost/list")
    public String laborCostList(Model m){
        List<LaborCost> laborCostList=laborCostRepo.findAll();
        m.addAttribute("title","Labor Cost List");
        m.addAttribute("laborCostList", laborCostList);
        return "bill/laborCostList";
    }
    @GetMapping("/labor_cost/addform")
    public String laborCostform(Model m){

//        style dropdeown
        List<Style> styleList=iStylerepo.findAll();
        m.addAttribute("styleList", styleList);
//        style dropdeown end
//        Department start
        List<Department> departmentList=departmentRepo.findAll();
        m.addAttribute("departmentList", departmentList);
//        Department end
        m.addAttribute("laborCost",new LaborCost());
        m.addAttribute("title","Create New Labor Cost");
        return "bill/laborCostForm";
    }
    @PostMapping("/labor_cost/save")
    public String laborCostSave(@ModelAttribute LaborCost laborCost){
        laborCostRepo.save(laborCost);
        return "redirect:/labor_cost/list";
    }
    @GetMapping("/labor_cost/delete/{id}")
    public String laborCostDelete(@PathVariable int id){
        laborCostRepo.deleteById(id);
        return "redirect:/labor_cost/list";
    }

    @GetMapping("/labor_cost_edit/{id}")
    public String laborCostEdit(@PathVariable int id,Model m){
        LaborCost laborCostName=laborCostRepo.findById(id).get();
        m.addAttribute("title","Update Labor Cost");
        m.addAttribute("laborCostName",laborCostName);
        return "bill/laborCostForm";

    }

    //Labor cost end

    //Order details by Id

    @GetMapping("/receipt/{id}")
    public String getReceipt(@PathVariable int id,Model m){
        OrderDetails details=orderDetailsRepo.findById(id).get();
        m.addAttribute("details",details);
        return "other/receipt";

    }
    //Order details by Id end
}
