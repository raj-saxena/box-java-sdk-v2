package com.box.boxjavalibv2.resourcemanagers;

import com.box.boxjavalibv2.dao.BoxViewItem;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxServerException;
import com.box.restclientv2.exceptions.BoxRestException;

public interface IBoxViewManager extends IBoxResourceManager {
	
	/**
	 * Submit document to view API using the publicUrl of file and the apiKey.
	 * @param publicUrl
	 * @param apiKey
	 * @return BoxViewItem
	 * @throws BoxRestException 
	 * @throws BoxServerException 
	 * @throws AuthFatalFailureException 
	 */
	public BoxViewItem postDocumentByUrl(String publicUrl, String apiKey) throws BoxRestException, AuthFatalFailureException, BoxServerException;

}
