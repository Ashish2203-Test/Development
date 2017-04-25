package amazon;

import amazon.AWSECommerceService;
import amazon.AWSECommerceServicePortType;
import amazon.ItemSearchRequest;
import amazon.ItemSearchResponse;
import amazon.ItemSearch;
import amazon.Items;
import amazon.Item;
import amazon.AwsHandlerResolver;
import java.util.List;

class AmazonClientBareStyle{

	public static void main(String[] args){
		if(args.length<2){
			System.err.println("AmazonClientBareStyle <accessId> <secretKey>");
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
 		ItemSearchResponse response=port.itemSearch(itemSearch);
 		List<Items> itemsList=response.getItems();
 		int i=1;
 		for(Items next:itemsList)
 			for(Item item:next.getItem())
 				System.out.println(String.format("%2d: ", i++)+item.getItemAttributes().getTitle());

	}


}