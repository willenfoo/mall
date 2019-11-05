<#assign  packageSplit="${entity?uncap_first}"/>
package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>


    @Autowired
    private ${entity}Service orderService;

    @ApiOperation("新增")
    @PostMapping
    public R<SimpleResult<Boolean>> add(@Validated @RequestBody ${entity}AddReq addReq) {
       ${entity}DTO orderDto = new ${entity}Dto();

       BeanUtils.copyProperties(addReq, orderDto);
       Boolean updateFlag = orderService.save(orderDto);
       return successResult(updateFlag);
    }

    @ApiOperation("修改")
    @PostMapping(value = "{id}")
    public R<SimpleResult<Boolean>> update(
        @PathVariable("id") Long id,
        @Validated @RequestBody OrderUpdateReq updateReq) {
        ${entity}Dto orderDto = new ${entity}Dto();
        orderDto.setId(id);
        BeanUtils.copyProperties(updateReq, orderDto);
        Boolean updateFlag = orderService.updateById(orderDto);
        return successResult(updateFlag);
     }

    @ApiOperation("根据id查询")
    @GetMapping(value = "{id}")
    public R<${entity}Resp> findById(@PathVariable("id") String id) {
        OrderDto orderDto = orderService.queryDetailById(id);
        OrderResp orderResp = new OrderResp();
        BeanUtils.copyProperties(orderDto, orderResp);
        return success(orderResp);
    }

   @ApiOperation("查询列表")
   @GetMapping
   public R<PagerResult<${entity}Resp>> list(PagerQuery pagerQuery, ${entity}ListReq listReq) {
       ${entity}QueryDTO queryDTO = new ${entity}QueryDTO();
       BeanUtils.copyProperties(listReq, queryDTO);
       PagerResult<${entity}DTO> pagerResult = orderService.queryList(pagerQuery, queryDTO);
       return successPager(pagerResult, OrderResp.class);
   }

   @ApiOperation("查询列表-->导出")
   @GetMapping("export")
   public void export(${entity}ListReq listReq) {
      PagerQuery pagerQuery = new PagerQuery();
      pagerQuery.setCurrent(1);
      pagerQuery.setSize(50000L);
      ${entity}QueryDTO queryDTO = new ${entity}QueryDTO();
      BeanUtils.copyProperties(listReq, queryDTO);

      PagerResult<${entity}DTO> pagerResult = orderService.queryList(pagerQuery, queryDTO);
      List<${entity}DTO> list = pagerResult.getRecords();
      List<${entity}Resp> orderResps = CollectionUtils.transform(list, new Transformer() {
         @Override
         public Object transform(Object o) {
         ${entity}Resp orderResp = new ${entity}Resp();
         BeanUtils.copyProperties(o, orderResp);
         return orderResp;
         }
      });

      OutputStream out = null;
      try {
          //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
          response.setContentType("multipart/form-data");
          //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
          response.setHeader("Content-Disposition", initDownloadFileName("打款白名单列表", "xlsx"));
          out = response.getOutputStream();

          ExportParams params = new ExportParams();
          params.setSheetName("列表");
          params.setType(ExcelType.XSSF);
          params.setDictHandler(new ExcelDictHandlerImpl());
          Workbook workbook = ExcelExportUtil.exportExcel(params, ${entity}Resp.class, orderResps);
          workbook.write(out);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
            if (out != null) {
               try {
               out.flush();
               out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
    }
   }

}
</#if>
