package com.spboot.mapper;
import com.spboot.bean.Twareunite;
import com.spboot.bean.Twareunitegeneralname;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    TwareuniteMapper twareuniteMapper;

    @Autowired
    TwareunitegeneralnameMapper twareunitegeneralnameMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {

        Twareunite twareunite = twareuniteMapper.selectByPrimaryKey(117L);
        System.out.printf(twareunite.getSchemeName());

    }

    @Test
    public void insertUnite() throws Exception {

        for (int j = 4; j < 5; j++) {
            Twareunite twareunite = new Twareunite();
            twareunite.setGroupId(100L);
            twareunite.setCompanyId(10002L);
            twareunite.setSchemeName("联合用药测试数据" + (j));
            twareunite.setUniteStatus((byte) 1);
            twareunite.setClassify((byte) 2); //通用名
            twareunite.setIndications("感冒咳嗽");
            twareunite.setPosShowOrder(0);
            twareunite.setCheckerScript("");
            twareunite.setNotes("");
            twareunite.setCreateUser(1003L);
            twareunite.setCreateTime(new Date());
            twareunite.setModifyUser(1003L);
            twareunite.setModifyTime(new Date());
            twareuniteMapper.insert(twareunite);

            Twareunitegeneralname twareunitegeneralname = new Twareunitegeneralname();
            twareunitegeneralname.setUniteId(twareunite.getUniteId());
            twareunitegeneralname.setGenericNameRecordId(1L);
            twareunitegeneralnameMapper.insert(twareunitegeneralname);

            twareunitegeneralname = new Twareunitegeneralname();
            twareunitegeneralname.setUniteId(twareunite.getUniteId());
            twareunitegeneralname.setGenericNameRecordId(3L);
            twareunitegeneralnameMapper.insert(twareunitegeneralname);

            twareunitegeneralname = new Twareunitegeneralname();
            twareunitegeneralname.setUniteId(twareunite.getUniteId());
            twareunitegeneralname.setGenericNameRecordId(4L);
            twareunitegeneralnameMapper.insert(twareunitegeneralname);

            System.out.println("============"+twareunite.getUniteId()+"============");
        }
    }
}
