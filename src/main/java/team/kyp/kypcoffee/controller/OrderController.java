package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.OrderCommand;
import team.kyp.kypcoffee.domain.Product_info;
import team.kyp.kypcoffee.service.OrderInfoService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderInfoService orderInfoService;

    @PostMapping("/orderList")
    public String order(HttpSession session, OrderCommand orderCommand, Model model) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        int memberNum = ai.getNo();

        Member member = orderInfoService.memberInfoByMemberNum(memberNum); // 멤버 정보 - 문제없음

        ArrayList<Integer> cartNum = orderCommand.getCartNum(); // 문제없음

        List<Product_info> pInfos = orderInfoService.productInfo(cartNum);

        model.addAttribute("member", member);
        model.addAttribute("pInfos", pInfos);

        return "orders/order";
    }
}
