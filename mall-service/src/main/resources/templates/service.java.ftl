package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

     /**
      * 根据id查询，查询不到会抛出异常
      * @param id
      * @return
      */
     ${entity} queryById(Long id);

     /**
      * 根据id查询，需要返回更多字段，用dto扩展，查询不到会抛出异常
      * @param id
      * @return
      */
     ${entity}DTO queryDetailById(Long id);

     /**
      * 分页查询
      * @param pagerQuery
      * @param queryDto
      * @return
      */
      PagerResult<${entity}DTO> queryList(PagerQuery pagerQuery, ${entity}QueryDTO queryDTO);
}
</#if>
