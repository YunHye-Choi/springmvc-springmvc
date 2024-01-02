package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String username,
            @RequestParam(required = true) int age
    ){
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = false, defaultValue = "user") String username,
            @RequestParam(required = true, defaultValue = "-1") int age
    ){
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody // : return값을 응답 바디에 박아넣음 (@RestController와 같은 기능)
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        String username = (String) paramMap.get("username");
        int age = Integer.parseInt((String)paramMap.get("age"));
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        String username = helloData.getUsername();
        int age = helloData.getAge();
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        String username = helloData.getUsername();
        int age = helloData.getAge();
        log.info("username={}, age={}", username, age);

        return "ok";
    }
}
