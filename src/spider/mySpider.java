package spider;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class mySpider extends Spider{

	public mySpider(PageProcessor pageProcessor) {
		super(pageProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void setSite(Site site) {
        this.site = site;
    }
	
	 public static mySpider createTo(PageProcessor pageProcessor) {
	        return new mySpider(pageProcessor);
	 }

	@Override
	public mySpider addPipeline(Pipeline pipeline) {
		checkIfRunning();
        this.pipelines.add(pipeline);
        return this;
	}

	 
	 
}
