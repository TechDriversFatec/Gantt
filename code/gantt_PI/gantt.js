google.charts.load('current', {'packages':['gantt']});
google.charts.setOnLoadCallback(drawChart);

function toMilliseconds(minutes) {
      return minutes * 60 * 1000;
    }

    function drawChart() {

      var otherData = new google.visualization.DataTable();
      otherData.addColumn('string', 'Task ID');
      otherData.addColumn('string', 'Task Name');
      otherData.addColumn('string', 'Resource');
      otherData.addColumn('date', 'Start');
      otherData.addColumn('date', 'End');
      otherData.addColumn('number', 'Duration');
      otherData.addColumn('number', 'Percent Complete');
      otherData.addColumn('string', 'Dependencies');
      
      otherData.addRows([
        ['1', 'Task 1', 'completed', null, null, toMilliseconds(60), 100, null],
        ['2', 'Task 2', 'completed', null, null, toMilliseconds(40), 14, '1'],
        ['3', 'Task 3','To do', null, null, toMilliseconds(35), 89, '2'],
        ['4', 'Task 4', 'completed', null, null, toMilliseconds(20), 100, null],
        ['5', 'Task 5', 'Working', null, null, toMilliseconds(45), 50, '4'],
        ['6', 'Task 6', 'Working', null, null, toMilliseconds(10), 100, null],
        ['7', 'Task 7', 'To do', null, null, toMilliseconds(45), 75, '6'],
        ['8', 'Task 8', 'To do', null, null, toMilliseconds(10), 0, '7'],
      ]);

      var options = {
        height: 2000,
        gantt: {
          defaultStartDateMillis: new Date(2015, 3, 28)
        }
      };

      var chart = new google.visualization.Gantt(document.getElementById('gantt'));

      chart.draw(otherData, options);
      
}
    