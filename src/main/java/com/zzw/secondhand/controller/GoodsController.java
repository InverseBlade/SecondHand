package com.zzw.secondhand.controller;

import com.zzw.secondhand.dto.GoodsFormDTO;
import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.dto.GoodsListFilter;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.service.FavoriteService;
import com.zzw.secondhand.service.GoodsService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @Resource
    FavoriteService favoriteService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public JsonRes submit(GoodsFormDTO goodsFormDTO, HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("session:userId");
        return goodsService.add(goodsFormDTO, uid);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonRes<Goods> detail(@PathVariable("id") Integer goodsId) {
        return goodsService.findById(goodsId);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonRes<List<GoodsListDTO>> list(GoodsListFilter filter, Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        return goodsService.listGoods(filter, page, limit);
    }

    @RequestMapping(value = "favorite", method = RequestMethod.POST)
    public JsonRes favorite(Integer goodsId, HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("session:userId");
        return favoriteService.create(uid, goodsId);
    }

}
