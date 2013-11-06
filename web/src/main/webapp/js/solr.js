$(document).ready(function() {
  $('#search').autocomplete({
    source: function(request, response) {
      $.ajax({
        url: 'http://localhost:8983/solr/terms?',
        dataType: 'jsonp',
        data: {
          wt: 'json',
          'json.nl': 'arrarr',
          'terms.prefix': request.term
        },
        jsonp: 'json.wrf',
        success: function(data) {
          response($.map(data.terms.grammedContentEn, function(item) {
            return {
              label: item[0],
              value: item[0]
            };
          }));
        }
      });
    }
  });
});