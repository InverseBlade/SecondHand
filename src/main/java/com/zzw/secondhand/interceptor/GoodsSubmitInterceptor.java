package com.zzw.secondhand.interceptor;

import com.zzw.secondhand.dao.GoodsDao;
import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.util.Functions;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GoodsSubmitInterceptor implements HandlerInterceptor {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        try {
            int uid = (Integer) request.getAttribute("session:userId");
            String goodsParam = request.getParameter("id");

            if (goodsParam == null) {
                return true;
            }
            int goodsId = Integer.parseInt(goodsParam);
            int sellerId = goodsDao.selectById(goodsId).getSellerId();
            if (sellerId != uid) {
                throw new Exception("Invalid operation");
            }
            return true;
        } catch (Exception e) {
            Functions.invalidReturn(response);
            return false;
        }
    }
}
