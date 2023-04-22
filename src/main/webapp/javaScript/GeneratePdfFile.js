jQuery(document).ready(function () {
    $('#generateId').click(function () {
        let content = $('.class-to-print').html();
        let pdf = new jsPDF();

        // Add watermark image
        let img = new Image();
        img.src = 'path/to/image.jpg';
        img.onload = function() {
            pdf.setOpacity(0.3);
            pdf.addImage(this, 0, 0, pdf.internal.pageSize.getWidth(), pdf.internal.pageSize.getHeight());
            pdf.setOpacity(1);
            pdf.fromHTML(content, 10, 10, {'width': 180});
            pdf.save('document.pdf');

        }
    });
});