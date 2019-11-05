<#assign  packageSplit="${package.Entity}"?split(".")/>
package ${packageSplit[0]}.${packageSplit[1]}.${packageSplit[2]}.controller.vo.${entity?lower_case};

import lombok.Data;

/**
 * <p>
 * ${table.comment!}新增, 修改, 查询符合的公共字段
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
public class CommonAttribute {

}
