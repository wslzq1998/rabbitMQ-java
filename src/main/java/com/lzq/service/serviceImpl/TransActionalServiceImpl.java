package com.lzq.service.serviceImpl;

import com.lzq.model.Goods;
import com.lzq.model.Order;
import com.lzq.service.GoodsService;
import com.lzq.service.OrderService;
import com.lzq.service.TransActionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransActionalServiceImpl implements TransActionalService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;

    @Transactional(propagation = Propagation.REQUIRED)//有事务就加入到事务中，没有就新建一个事务
    //@Transactional(propagation = Propagation.SUPPORTS)//有事务就事务执行，没有就非事务执行
    //@Transactional(propagation = Propagation.MANDATORY)//有事务就事务执行,没有事务就抛错
    //@Transactional(propagation = Propagation.REQUIRES_NEW)//开启一个新的事务，如果事务已经存在，则将这个事务挂起
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)//非事务的执行方法，如果事务已经存在，则将这个事务挂起
    //@Transactional(propagation = Propagation.NEVER)//非事务的执行方法，如果事务已经存在，则抛出异常
    //@Transactional(propagation = Propagation.NESTED)//外层事务失败会使内层事务回滚，内层事务失败不会使外层事务回滚
    /* PROPAGATION_NESTED 与 PROPAGATION_REQUIRES_NEW的区别:
            PROPAGATION_REQUIRES_NEW：内层事务与外层事务就像两个独立的事务
            PROPAGATION_NESTED：外层事务的回滚可以引起内层事务的回滚。而内层事务的异常并不会导致外层事务的回滚
    */
    public void orderInsert(){
        Order order = new Order();
        order.setUserId("1");
        order.setGoodsId("10");
        order.setPayStatus("2");
        orderService.orderInsert(order);
    }
    @Transactional(propagation = Propagation.NEVER)
    public void goodsInsert(){
        Goods goods = new Goods();
        goods.setGoodsName("薯片");
        goods.setGoodsCount("1001");
        goods.setGoodsPrice("999");
        goodsService.insertGoods(goods);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void goodsAndOrderInsert(){
        Order order = new Order();
        order.setUserId("1");
        order.setGoodsId("10");
        order.setPayStatus("3");
        orderService.orderInsert(order);
        Goods goods = new Goods();
        goods.setGoodsName("薯片");
        goods.setGoodsCount("1001");
        goods.setGoodsPrice("9999");
        goodsService.insertGoods(goods);

    }
}
