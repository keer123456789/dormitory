package com.keer.dormitory.service.impl;

import com.keer.dormitory.entity.Block;
import com.keer.dormitory.mapper.BlockMapper;
import com.keer.dormitory.service.BlockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宿舍楼信息 服务实现类
 * </p>
 *
 * @author linhui
 * @since 2021-03-23
 */
@Service
public class BlockServiceImpl extends ServiceImpl<BlockMapper, Block> implements BlockService {

}
