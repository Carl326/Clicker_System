/*
setInterval(function() {
   redraw();
 }, 1500);
 */

var w = 20,
      h = 80;
  
  var x = d3.scale.linear()
      .domain([0, 1])
      .range([0, w]);
  
  var y = d3.scale.linear()
      .domain([0, 10])
     .rangeRound([0, h]);
	 
	 var chart = d3.select("body").append("svg")
     .attr("class", "chart")
     .attr("width", w * histData.length - 1)
     .attr("height", h);
	 
chart.selectAll("rect")
     .data(histData)
   .enter().append("rect")
     .attr("x", function(d, i) { return x(i) - .5; })
     .attr("y", function(d) { return h - y(d) - .5; })
     .attr("width", w)
     .attr("height", function(d) { return y(d); });

chart.selectAll("line")
     .data(x.ticks(10))
	 .enter().append("line")
     .attr("x1", 0)
     .attr("x2", 200)
     .attr("y1", h*10)
     .attr("y2", h*10)
     .style("stroke", "#ccc");
	 

	 
chart.append("line")
     .attr("x1", 0)
     .attr("x2", w * histData.length)
     .attr("y1", h - .5)
     .attr("y2", h - .5)
     .style("stroke", "#000");

function redraw() {
  
    // Update…
    chart.selectAll("rect")
        .data(histData)
      .transition()
        .duration(500)
        .attr("y", function(d) { return h - y(d) - .5; })
        .attr("height", function(d) { return y(d); });
 
 }