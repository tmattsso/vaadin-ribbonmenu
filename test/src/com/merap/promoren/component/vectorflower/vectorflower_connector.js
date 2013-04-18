var outer_static_id_variable = 48233696;

window.com_merap_promoren_component_vectorflower_VectorFlowerComponent = function() {
	
    
	var self = this;
	var theimg = null;
	var current_resource_URL = null;
	var oldWidth = "";
	var oldHeight = "";

	self.getElement().sizeUpdated = function() {
		//console.log("Size changed", theimg.parentNode.offsetWidth, theimg.parentNode.offsetHeight, self.getElement().offsetWidth);

		if (theimg !== null) {
			oldWidth = self.getElement().offsetWidth;
			oldHeight = self.getElement().offsetHeight;
			$(theimg).smoothZoom('resize', {width: oldWidth, height: oldHeight});
		}
		
	};
	
    this.onStateChange = function() {

    	var resource = self.getState().resources["vf-img"];
    	
    	// new picture or first one
    	if (current_resource_URL === null || resource.uRL !== current_resource_URL) {
    		// If there is already a child, remove it
    		if (current_resource_URL !== null) {
    			self.getElement().removeChild(theimg.parentNode);
    		}

    		// create a new element and append it
    		theimg = document.createElement("img");
    		self.getElement().appendChild(theimg);
    		
    		var img_src = self.translateVaadinUri(resource.uRL);
    		theimg.setAttribute('src', img_src);
    		
    		// The "constructor". 
    		$(theimg).smoothZoom({
    			width: self.getState().height,
    			height: self.getState().width
    		});
    		
    		current_resource_URL = resource.uRL;
    	
    	// Otherwise, update request to existing picture
    	} else {
    		
    		var stateWidth = self.getState().width.replace("px", "");
    		var stateHeight = self.getState().height.replace("px", "");
    		
    		// Only resize if size has changed
    		if (oldWidth !== stateWidth || oldHeight != stateHeight) {
    			$(theimg).smoothZoom('resize', {width: stateWidth, height: stateHeight});
    		}
    		
    	}
    	
    	// It seemed like a bug to add pixels to the zoomer dimensions, so we must remove the "px" part
		oldWidth = self.getState().width.replace("px", "");
		oldHeight = self.getState().height.replace("px", "");   		
    };
};

