package ee.api;

import ee.bean.Test;
import ee.bean.User;
import ee.service.ITestService;
import ee.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/3/22.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService iTestService;
    @Autowired
    private ITransactionService transactionService;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        return iTestService.testMethod1();
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        try {
            return iTestService.testMethod2();
        } catch (Exception e) {
            e.printStackTrace();
            return "sheng ming shi shi wu";
        }
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(HttpServletRequest request, @RequestBody Test test) {
        return iTestService.testMethod3(test, request);
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4() {
        return iTestService.testMethod4();
    }

    @RequestMapping("/transaction1")
    @ResponseBody
    public String test5() {
        transactionService.transaction1();
        return "success";
    }
}
