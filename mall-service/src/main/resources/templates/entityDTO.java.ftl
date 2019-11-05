<#assign  packageSplit="${package.Entity}"?split(".")/>
package ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.dto.${entity?lower_case};

import ${package.Entity}.${entity};

import lombok.Data;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
public class ${entity}DTO extends ${entity} {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

}
