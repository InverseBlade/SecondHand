package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.GoodsDao;
import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.dto.GoodsFormDTO;
import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.dto.GoodsListFilter;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.GoodsService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private UserDao userDao;

    @Override
    public JsonRes<Goods> findById(Integer id) {
        try {
            Goods goods;
            if ((goods = goodsDao.selectById(id)) == null) {
                return new JsonRes<>(1, "not found");
            }
            return new JsonRes<Goods>(0, "").setData(goods);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<Integer> add(GoodsFormDTO goodsFormDTO, Integer userId) {
        try {
            int id;
            Goods goods = new Goods();
            BeanUtils.copyProperties(goodsFormDTO, goods);
            //TO-DO
            User user;
            if ((user = userDao.selectById(userId)) == null) {
                throw new Exception("用户非法!");
            }
            goods.setSubmitTime(new Timestamp(System.currentTimeMillis()))
                    .setBuyTime(null)
                    .setBuyerId(0)
                    .setSellerId(user.getId())
                    .setStatus("上架")
                    .setRead(0);
            goodsDao.insertAndGetId(goods);
            id = goods.getId();
            return new JsonRes<Integer>(0, "succeed").setData(id);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes modifySelectiveById(GoodsFormDTO goodsFormDTO) {
        try {
            Goods goods = new Goods();
            BeanUtils.copyProperties(goodsFormDTO, goods);
            goodsDao.updateSelectiveById(goods);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes removeById(Integer id) {
        try {
            goodsDao.deleteById(id);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<List<GoodsListDTO>> listGoods(GoodsListFilter filter, Integer page, Integer limit) {
        try {
            List<GoodsListDTO> goods;
            int offset = (page - 1) * limit;

            //TO-DO
            filter.setStatus("上架");

            goods = goodsDao.listGoods(filter, offset, limit);
            return new JsonRes<List<GoodsListDTO>>(0, "succeed")
                    .setData(goods);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<List<GoodsListDTO>> listSoldByUserId(Integer userId) {
        return null;
    }

    @Override
    public JsonRes<List<GoodsListDTO>> listBoughtByUserId(Integer userId) {
        return null;
    }

    @Override
    public JsonRes increaseRead(Integer id) {
        try {
            goodsDao.increaseRead(id);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes updateStatus(Integer id, String status) {
        try {
            goodsDao.updateSelectiveById(
                    new Goods().setId(id).setStatus(status));
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes buy(Integer userId, Integer goodsId) {
        try {
            goodsDao.updateSelectiveById(
                    new Goods().setId(goodsId)
                            .setSellerId(userId)
                            .setBuyTime(new Timestamp(System.currentTimeMillis()))
                            .setStatus("已售")
            );
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }
}
