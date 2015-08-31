$('.gamecmp').click(function(){
if (!($(".item_block").hasClass("active_item_block"))) {alert('You didn`t activate any block. Click on the block to make it active.'); return 0;}
var cmp_img=$(this).css('background-image');
var cmp_img_pos=$(this).css('background-position');
var cmp_id=$(this).attr('id');
var block_id=$(".active_item_block").attr("id").split("_");
$('.active_item_block').add( "<div alt='"+cmp_id+"' block-id="+block_id[2]+" class='chosen_item' style='background-image: "+cmp_img+";'><div></div></div>" ).appendTo('.active_item_block');
}
);
var num=1;
$('.addblock').click(function(){
$('.items').add( "<div id='item_block_"+num+"' class='item_block'><div class='block_stuff'><button class='del_item_block'>[X]</button><p>Block name:<input class='item_block_name' name='item_block_name"+num+"' type='text'> Block comment:<input class='item_block_comm' name='item_block_comm"+num+"' type='text'></p></div></div>" ).appendTo('.items');
num+=1;
});
$(".items").delegate(".item_block", "click", function(){
$('.item_block').removeClass("active_item_block");
$(this).addClass("active_item_block");
});

//DELETE

$(".items").delegate(".del_item_block", "click", function(){
$(this).parent().parent().remove();
});
$(".items").delegate(".chosen_item", "click", function(){
$(this).remove();
});

//SEND


//GRAPHICS

$("#search_button, #search_input").hover(function(){
$("#search_input")
	.css({display: "block"})
	.stop(true).animate({opacity: "1"}, 300)
	.focus();
}, function(){
$("#search_input").css({display: "none"});
$("#search_input").stop(true).animate({opacity: "0"}, 300);
});

$(".sort_block>ul>li").click (function(){
$(".sort_block>ul>li").removeClass("active_sort_block");
$(this).addClass("active_sort_block");
$(".gamecmp").css({display: "none"});

$(".gamecmp").each(function() {
if($(this).attr("tag")==$(".active_sort_block").attr("tag")) {$(this).css({display: "block"})}
});
});

var saveval;
$("#guide_name").click(function(){
saveval=$(this).val();
$(this).val(""); 
});
$("#guide_name").blur(function(){
if (this.value=='') {
this.value=saveval;
}
});

$(".hideEmail").click(function(){
$(".hideEmail").html("coshe@ukr.net");
});