var map = new BMap.Map("container");
// 创建地图实例
var point = new BMap.Point(116.404, 39.915);
// 创建点坐标
map.centerAndZoom(point, 15);
// 初始化地图，设置中心点坐标和地图级别
map.enableScrollWheelZoom(true);
map.addControl(new BMap.NavigationControl());
map.addControl(new BMap.ScaleControl());
map.addControl(new BMap.OverviewMapControl());
map.addControl(new BMap.MapTypeControl());
map.setCurrentCity("北京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用