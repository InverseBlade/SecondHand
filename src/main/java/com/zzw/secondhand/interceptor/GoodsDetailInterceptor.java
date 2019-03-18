package com.zzw.secondhand.interceptor;

import com.zzw.secondhand.dao.GoodsDao;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.util.Functions;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class GoodsDetailInterceptor implements HandlerInterceptor {

    @Resource
    GoodsDao goodsDao;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        try {
            int uid = (Integer) request.getAttribute("session:userId");
            //处理以PathVariable传入的GoodsId
            NativeWebRequest webRequest = new ServletWebRequest(request);
            Map<String, String> map =
                    (Map<String, String>) webRequest.getAttribute(
                            HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE,
                            RequestAttributes.SCOPE_REQUEST);
            if (map != null && map.get("id") != null) {
                try {
                    int goodsId = Integer.parseInt(map.get("id"));
                    Goods goods = goodsDao.selectById(goodsId);
                    if (!goods.getStatus().equals("上架") && uid != goods.getSellerId()) {
                        throw new Exception("Invalid Operation");
                    }
                } catch (NumberFormatException e) {
                    return true;
                }
            }
            return true;
        } catch (Exception e) {
            Functions.invalidReturn(response);
            return false;
        }
    }
}
