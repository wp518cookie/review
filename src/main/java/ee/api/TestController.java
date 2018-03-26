package ee.api;

import ee.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/22.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService iTestService;

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
}
