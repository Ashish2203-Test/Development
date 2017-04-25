package client;

import amazon.*;
import java.util.List;

class AWSClient{
	public static void main(String[] args){
		if(args.length<2){
			System.err.println("AWSClient <accessId> <secretKey>");
			return;
		}
		final String accessId=args[0];
		final String secretKey=args[1];
		
		AWSECommerceService service=new AWSECommerceService();
		service.setHandlerResolver(new AwsHandlerResolver(secretKey));
		AWSECommerceServicePortType port=service.getAWSECommerceServicePort();
		
		ItemSearchRequest request=new ItemSearchRequest();
		request.setSearchIndex("Books");
		request.setKeywords("Austen");
		
		ItemSearch itemSearch=new ItemSearch();
		itemSearch.setAWSAccessKeyId(accessId);
		itemSearch.setAssociateTag("kalin");
		itemSearch.getRequest().add(request);
		
		ItemSearchResponse response=port.itemSearch(itemSearch);
		List<Items> itemList=response.getItems();
		int i=1;
		for(Items next: itemList)
			for(Item item:next.getItem())
				System.out.println(String.format("%2d: ", i++)+item.getItemAttributes().getTitle());
	
	}
}