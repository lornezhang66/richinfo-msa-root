package com.richinfo.zuul.Filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 此类描述的是：路由过滤器<br/>
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：<br/>
 * pre：可以在请求被路由之前调用<br/>
 * routing：在路由请求时候被调用<br/>
 * post：在routing和error过滤器之后被调用<br/>
 * error：处理请求时发生错误时被调用<br/>
 * filterOrder：通过int值来定义过滤器的执行顺序<br/>
 * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效<br/>
 * run：过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
 * 不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
 * 当然我们也可以进一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
 * @author: lornezhang
 * @version: 2017年8月10日 上午11:24:44
 */
public class MsaZuulFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(MsaZuulFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
        	logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器的执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
