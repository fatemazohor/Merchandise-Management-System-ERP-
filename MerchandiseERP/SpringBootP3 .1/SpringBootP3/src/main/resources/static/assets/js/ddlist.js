
    $('document').ready(function(){
    $('#styleCode').on('change',function (){
        $('#measurementid').empty().append('<option value="null">-Select-</option>');
        var styleId=$(this).val();
        var href="http://localhost:8088/style/"+styleId
        $.get(href,function (style,status){
            var styleMeasurement = style.styleMeasurement;
            for(var i=0; i<= styleMeasurement.length-1; i++){
                $('#measurementid').append('<option value=" '+styleMeasurement[i].id+' ">'+styleMeasurement[i].name+'</option>');
            }
        })
    })
})

    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;

        window.print();

        document.body.innerHTML = originalContents;
    }

