package com.casic.activiti.web.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.impl.form.StartFormDataImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dynamic")
public class DynamicController {


	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private FormService formService;

	/**
	 * 获取已经部署的流程
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().active().orderByDeploymentId().desc();
		List<ProcessDefinition> list = query.list();

		request.setAttribute("list", list);

		return "dynamic/list";

	}

	@RequestMapping(value = "/from/{processDefinitionId}",method = RequestMethod.GET )
	public String from(@PathVariable("processDefinitionId") String processDefinitionId, HttpServletRequest request, HttpServletResponse response) {

		StartFormDataImpl startFormData = (StartFormDataImpl) formService.getStartFormData(processDefinitionId);
		request.setAttribute("form", startFormData);

		return "dynamic/from";

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/from/{processDefinitionId}",method = RequestMethod.POST )
	public String dopost(@PathVariable("processDefinitionId") String processDefinitionId, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("进程:============"+processDefinitionId);
		
        Map<String, String> formProperties = new HashMap<String, String>();

        // 从request中读取参数然后转换
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
        for (Entry<String, String[]> entry : entrySet) {
            String key = entry.getKey();
            formProperties.put(key, entry.getValue()[0]);
        }
		
        ProcessInstance processInstance =formService.submitStartFormData(processDefinitionId, formProperties);

        System.out.println( "启动成功，流程ID：" + processInstance.getId());
        
		return "dynamic/from";

	}

}
