<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19-6-26
  Time: 上午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="u">
    <title>示例</title>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=u5CNodaA3rFoWqcKcEhlpfDz"></script>
</head>

<body>
<div class="map">
    <div style="width:1100px;height:400px" id="map"></div>
</div>
<script type="text/javascript">
    function initMap() {
        createMap();	//初始化地图
        addMapControl();//加载地图控件，非必须
        addMapOverlay();//向地图添加覆盖物
    }

    function createMap() {
        map = new BMap.Map("map");
        //设置地图中心点经度、纬度、缩放比例
        map.centerAndZoom(new BMap.Point(121.491,31.233), 16);
        map.enableScrollWheelZoom();
        map.enableKeyboard();
        map.enableDragging();
        map.enableDoubleClickZoom()
    }
    function addClickHandler(target, window) {
        target.addEventListener("click", function () {
            target.openInfoWindow(window);
        });
    }
    function addMapOverlay() {
        var markers = [
            { content: "备注", title: "我在这里", imageOffset: { width: 0, height: 3 }, position: { lat: 31.237 , lng:121.491 } }, // 纬度  经度
            { content: "备注", title: "TMD你在这里", imageOffset: { width: 0, height: 3 }, position: { lat: 31.234 , lng:121.493 } }  // 纬度  经度
        ];
        for (var index = 0; index < markers.length; index++) {
            var point = new BMap.Point(markers[index].position.lng, markers[index].position.lat);
            var marker = new BMap.Marker(point, {
                icon: new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png", new BMap.Size(20, 25), {
                    imageOffset: new BMap.Size(markers[index].imageOffset.width, markers[index].imageOffset.height)
                })
            });
            var label = new BMap.Label(markers[index].title, { offset: new BMap.Size(25, 5) });
            var opts = {
                width: 200,
                title: markers[index].title,
                enableMessage: false
            };
            var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
            marker.setLabel(label);
            addClickHandler(marker, infoWindow);
            map.addOverlay(marker);
        };
        var labels = [
        ];
        for (var index = 0; index < labels.length; index++) {
            var opt = { position: new BMap.Point(labels[index].position.lng, labels[index].position.lat) };
            var label = new BMap.Label(labels[index].content, opt);
            map.addOverlay(label);
        };
    }

    function addMapControl() {
        var scaleControl = new BMap.ScaleControl({ anchor: BMAP_ANCHOR_BOTTOM_LEFT });
        scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
        map.addControl(scaleControl);
        var navControl = new BMap.NavigationControl({ anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_LARGE });
        map.addControl(navControl);
        var overviewControl = new BMap.OverviewMapControl({ anchor: BMAP_ANCHOR_BOTTOM_RIGHT, isOpen: true });
        map.addControl(overviewControl);
    }
    var map;
    initMap();
</script>

</body>
</html>

