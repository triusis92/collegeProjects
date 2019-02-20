//Created by Lance

// flickr api url
var apiUrl = "https://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";
window.selectedThumbnail = '';
$(document).ready(function()
{
  window.itemsLength = 0;
  var thumbs = $('#thumbs');
  var selectedThumbnail = 0;
  var carouselWidth = $('#carousel').css('width').split('px')[0];
  var left = carouselWidth/3 + 107;
  
  // add button click function
  $('#addBtn').click(function(){
    var tagInput = '<input class="tags" type="text" name="tagInput" value="">' +
    '<a class="removeBtn btn">-</a>';
	$('#tagsInputs').append(tagInput);
  
  // remove button click function
	$('.removeBtn').click(function()
	{
    // remove the tag input
	  $(this).prev().remove();
    // remove the "remove button"
	  $(this).remove();
	});
  });
  
  $('.removeBtn').click(function()
  {
	$(this).prev().remove();
	$(this).remove();
  });
  
  // function for getting the previous image
  function displayPrevious()
  {
	if (selectedThumbnail > 0 && window.itemsLength > 0) 
	{
    //getting the calculated width of the carousel div
	  var value = 230 * (selectedThumbnail-1);
	  left = carouselWidth/3 + 107;
	  left -= value;
	  thumbs.css('margin-left',left+'px');
	  imgId = '#img'+selectedThumbnail;
    //removing the highlight from the current image
	  $(imgId).removeClass('selectedThumbnail');
    //getting the previous image id
	  selectedThumbnail--;
	  imgId = '#img'+selectedThumbnail;
    // highlighting the prev image
	  $(imgId).addClass('selectedThumbnail');
	  imgurl = $(imgId).css('background-image');
    // removing the current image from the "imgPreviewContainer"
	  $('#imgPreviewContainer').empty();
    // adding new one
	  $('#imgPreviewContainer').html('<div id="imgPreview" class="imgPreview" style=\'background-image: '+ imgurl +'\'></div>');
	}
  }
   //function for getting the next image
  function displayNext()
  {
	if (selectedThumbnail < window.itemsLength-1 && window.itemsLength > 0) 
	{
			var value = (230 * (selectedThumbnail+1));
			left = carouselWidth/3 + 107;
			left -= value;
			thumbs.css('margin-left',left+'px');
			imgId = '#img'+selectedThumbnail;
			$(imgId).removeClass('selectedThumbnail');
			selectedThumbnail++;
			imgId = '#img'+selectedThumbnail;
			$(imgId).addClass('selectedThumbnail');
			imgurl = $(imgId).css('background-image');
			$('#imgPreviewContainer').empty();
			$('#imgPreviewContainer').html('<div id="imgPreview" class="imgPreview" style=\'background-image: '+ imgurl +'\'></div>');
	}
	else if(selectedThumbnail >= window.itemsLength-1 && window.itemsLength > 0) //back to the start
	{
			left = carouselWidth/3 + 107;
			thumbs.css('margin-left',left+'px');
			imgId = '#img'+selectedThumbnail;
			$(imgId).removeClass('selectedThumbnail');
			selectedThumbnail = 0;
			imgId = '#img'+selectedThumbnail;
			$(imgId).addClass('selectedThumbnail');
			imgurl = $(imgId).css('background-image');
			$('#imgPreviewContainer').empty();
			$('#imgPreviewContainer').html('<div id="imgPreview" class="imgPreview" style=\'background-image: '+ imgurl +'\'></div>');
	}
  } 
  //getting the previous image
  $('#prev').click(function()
  {
	displayPrevious();
  });  
  //gettin the next image
  $('#next').click(function()
  {
		displayNext();
  });
  // highlighting and displaying the selected image on mouse click
  $(document).on("click", ".imgThumbnails", function()
  {
		if(window.itemsLength > 0) 
		{
			imgId = '#img'+selectedThumbnail;
			$(imgId).removeClass('selectedThumbnail');
			selectedThumbnail = parseInt($(this).attr('id').split('img')[1]);
			var value = 230 * selectedThumbnail;
			left = carouselWidth/3 + 107;
			left -= value;
			thumbs.css('margin-left',left+'px');
			imgId = '#img'+selectedThumbnail;
			$(imgId).addClass('selectedThumbnail');
			imgurl = $(imgId).css('background-image');
			$('#imgPreviewContainer').empty();
			$('#imgPreviewContainer').html('<div id="imgPreview" class="imgPreview" style=\'background-image: '+ imgurl +'\'></div>');
		}
  });
 
 // highlighting and displaying the selected image on key press
  $(window).keydown(function(event) 
  {
    // right key
    if(event.keyCode===39)
	{
		displayNext();
	}
    // left key
    else if(event.keyCode===37) 
	{
	  displayPrevious();  
    }
});

//searching flickr api using tags and the api key
  $('#findBtn').click(function()
  {
    $(this).empty();
    //adding loading class to find button to display the spinner for loading
    $(this).addClass('loading');
    var tags = '';
    imgToPreview = '';
    $('input').each(function(index, elem)
	{
      if ($(elem).val() != '') 
	  {
        tags = tags + $(this).val() + ',';
      }	 
 
    });
	
    var payload = {
      api_key: "ca370d51a054836007519a00ff4ce59e",
      tags: tags,
      format: "json"
    }
    //clear the images before adding
    thumbs.empty();
    //making the http request and search flickr api using tags
    $.getJSON(apiUrl,payload,function(res)
	{
		if(res.items.length<=0)//display message if no images found
		{
			alert("No Images corresponding to tags found. Please adjust content of your tags or reload the page.");
			$('#findBtn').removeClass('loading');
            $('#findBtn').html('Find Images');
		}
      //check that theres at least one image
      else if(res.items.length > 0) 
	  {
        window.itemsLength = res.items.length;
		
        //looping through the images
        $.each(res.items,function(index,item)
		{
          var imgDiv = '<div id="'+'img'+index+'" class="imgThumbnails" style="background-image: url('+item.media.m+');"></div>'
          //appending the thumbnails div with an image
          thumbs.append(imgDiv);
          //highlighting the first image
          if(index == 0)
		  {
            $('#img0').addClass('selectedThumbnail');
            $('#imgPreviewContainer').html('<div id="imgPreview" class="imgPreview" style="background-image: url('+item.media.m+');"></div>');
            window.selectedThumbnail = item.media.m;
            $('#findBtn').removeClass('loading');
            $('#findBtn').html('Find Images');
          }		  
        });
      }
    });
  });
});