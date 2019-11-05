<#assign  packageSplit="${package.Entity}"?split(".")/>
package ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.dto.${entity?lower_case};

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
public class ${entity}QueryDTO {

    /**
     * 创建时间，开始
     */
     private LocalDateTime gmtCreateStart;

    /**
     * 创建时间，结束
     */
     private LocalDateTime gmtCreateEnd;

}
