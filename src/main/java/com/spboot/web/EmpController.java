package com.spboot.web;

import com.spboot.bean.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
public class EmpController {

    // 创建线程安全的Map
    static Map<Long, Employee> emps = Collections.synchronizedMap(new HashMap<Long, Employee>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<Employee> r = new ArrayList<Employee>(emps.values());
        return r;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return emps.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute Employee emp) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        Employee u = emps.get(id);
//       u.setName(user.getName()); 
//       u.setAge(user.getAge()); 
        emps.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        emps.remove(id);
        return "success";
    }

}
