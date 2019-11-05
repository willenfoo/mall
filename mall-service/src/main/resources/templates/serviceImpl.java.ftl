<#assign  packageSplit="${package.Entity}"?split(".")/>
package ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.dto.${entity?lower_case};
package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.dto.${entity?lower_case}.${entity}DTO;
import ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.dto.${entity?lower_case}.${entity}QueryDTO;

import ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.common.ExceptionCode;

import lombok.extern.slf4j.Slf4j;
import org.apache.playframework.domain.PagerQuery;
import org.apache.playframework.domain.PagerResult;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Slf4j
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public ${entity} queryById(Long id) {
        ${entity} ${entity?uncap_first} = getById(id);
        if (${entity?uncap_first} == null) {
           throw new ApiException(ExceptionCode.${entity?upper_case}_NOT_EXIST);
        }
        return ${entity?uncap_first};
    }

    @Override
    public ${entity}DTO queryDetailById(Long id) {
        ${entity} ${entity?uncap_first} = queryById(id);
        return transform(Arrays.asList(order)).get(0);
    }

    @Override
    public PagerResult<${entity}DTO> queryList(PagerQuery pagerQuery, ${entity}QueryDTO queryDTO) {
       log.info("订单, 查询列表开始, pagerQuery:{}, queryDto:{}", pagerQuery, queryDto);
       LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper();
       queryWrapper.orderByDesc(${entity}::getId);
       //索引字段放在前面

       queryWrapper.gt(${entity}::getId, 0);
       if (!ObjectUtils.isEmpty(queryDTO.getCreateTimeStart())) {
          queryWrapper.ge(${entity}::getCreateTime, queryDTO.getCreateTimeStart());
       }
       if (!ObjectUtils.isEmpty(queryDTO.getCreateTimeEnd())) {
          queryWrapper.le(${entity}::getCreateTime, queryDTO.getCreateTimeEnd());
       }
       IPage<${entity}> iPage = page(new Page(pagerQuery.getCurrent(), pagerQuery.getSize()), queryWrapper);
       PagerResult<${entity}DTO> pagerResult = new PagerResult(transform(iPage.getRecords()), iPage.getTotal());
       log.info("订单, 查询列表结束");
       return pagerResult;
     }

    private List<${entity}DTO> transform(List<${entity}> ${entity?uncap_first}s) {
       if (ObjectUtils.isEmpty(${entity?uncap_first}s)) {
           return new ArrayList<>();
       }
       List<${entity}DTO> resultList = new ArrayList<>();
       for (${entity} ${entity?uncap_first} : ${entity?uncap_first}s) {
          ${entity}DTO ${entity?uncap_first}DTO = new ${entity}DTO();
          BeanUtils.copyProperties(${entity?uncap_first}, ${entity?uncap_first}DTO);
          resultList.add(o${entity?uncap_first}DTO);
       }
       return resultList;
    }

}
