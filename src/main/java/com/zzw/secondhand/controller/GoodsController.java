package com.zzw.secondhand.controller;

import com.zzw.secondhand.dto.*;
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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonRes save(GoodsFormDTO goodsFormDTO, HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("session:userId");
        if (goodsFormDTO.getId() == null) {
            return goodsService.add(goodsFormDTO, uid);
        } else {
            return goodsService.modifySelectiveById(goodsFormDTO);
        }
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

    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public JsonRes favorite(Integer goodsId, HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("session:userId");
        return favoriteService.create(uid, goodsId);
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public JsonRes read(Integer id) {
        return goodsService.increaseRead(id);
    }

    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public JsonRes status(Integer id, String status) {
        return goodsService.updateStatus(id, status);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.PUT)
    public JsonRes buy(Integer userId, Integer id) {
        return goodsService.buy(userId, id);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public JsonRes<UserBasicDTO> contact(Integer goodsId, HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("session:userId");
        return goodsService.contact(uid, goodsId);
    }

    @RequestMapping(value = "/listWillers", method = RequestMethod.GET)
    public JsonRes<List<WillerListDTO>> listWillers(Integer goodsId) {
        return goodsService.listWillers(goodsId);
    }

}
