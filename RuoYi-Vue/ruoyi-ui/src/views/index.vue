<template>
  <div class="all">
    <div class="banner">
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple header" >
          <h1>数据可视化面板</h1>
        </div>
      </el-col>
    </el-row>
  <el-row :gutter="260">
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <div class="mycharts">
          <div id="myChartsByPic" style="width: 450px;height: 300px;margin: 0 auto;"></div>
          <div class="btm"></div>
        </div>
      </div>
    </el-col>
    <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <div class="mycharts">
          <div id="myChartsByBar" style="width: 450px;height: 300px;margin: 0 auto"></div>
          <div class="btm"></div>
        </div>
      </div>
    </el-col>
  </el-row>
  <el-row :gutter="260">
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <div class="mycharts">
          <div id="myChartsByPicTwo" style="width: 450px;height: 378px;margin: 0 auto"></div>
          <div class="btm"></div>
        </div>
      </div>
    </el-col>
    <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <div class="mycharts">
          <div id="myChartsByBarTwo" style="width: 450px;height: 378px;margin: 0 auto"></div>
          <div class="btm"></div>
        </div>
      </div>
    </el-col>
  </el-row>
      <div id="myChartsByMap" style="width: 800px;height: 800px;margin: 0 auto;margin-top: -760px"></div>
    </div>
  </div>
</template>

<script>
  import * as echarts from 'echarts';
  import china from '../../public/js/china.json';
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
      startValue:0,//柱形图滚动
      endValue:4,
      option:{
          geo:{
      map:'china',
    }
  }
  };
  },
  created() {

  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    myChartsByPic(){
      var chartDom = document.getElementById('myChartsByPic');
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        color: ['#EAEA26', '#906BF9', '#FE5656', '#01E17E', '#3DD1F9', '#FFAD05'],
        // title: {
        //     text: '网络/安全设备',
        //     left: '60',
        //     top: 0,
        //     textAlign: 'center',
        //     textStyle: {
        //         color: '#fff',
        //         fontSize: 14,
        //         fontWeight: 0
        //     }
        // },
        grid: {
          left: -100,
          top: 50,
          bottom: 10,
          right: 10,
          containLabel: true
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b} : {c} ({d}%)'
        },
        legend: {
          type: 'scroll',
          orient: 'vartical',
          // x: "right",
          top: 'center',
          right: '15',
          // bottom: "0%",
          itemWidth: 16,
          itemHeight: 8,
          itemGap: 16,
          textStyle: {
            color: '#A3E2F4',
            fontSize: 12,
            fontWeight: 0
          },
          data: ['IDS', 'VPN', '交换机', '防火墙', 'WAF', '堡垒机']
        },
        polar: {},
        angleAxis: {
          interval: 1,
          type: 'category',
          data: [],
          z: 10,
          axisLine: {
            show: false,
            lineStyle: {
              color: '#0B4A6B',
              width: 1,
              type: 'solid'
            }
          },
          axisLabel: {
            interval: 0,
            show: true,
            color: '#0B4A6B',
            margin: 8,
            fontSize: 16
          }
        },
        radiusAxis: {
          min: 40,
          max: 120,
          interval: 20,
          axisLine: {
            show: false,
            lineStyle: {
              color: '#0B3E5E',
              width: 1,
              type: 'solid'
            }
          },
          axisLabel: {
            formatter: '{value} %',
            show: false,
            padding: [0, 0, 20, 0],
            color: '#0B3E5E',
            fontSize: 16
          },
          splitLine: {
            lineStyle: {
              color: '#0B3E5E',
              width: 0,
              type: 'solid'
            }
          }
        },
        calculable: true,
        series: [
          {
            type: 'pie',
            radius: ['5%', '10%'],
            hoverAnimation: false,
            labelLine: {
              normal: {
                show: false,
                length: 30,
                length2: 55
              },
              emphasis: {
                show: false
              }
            },
            data: [
              {
                name: '',
                value: 0,
                itemStyle: {
                  normal: {
                    color: '#0B4A6B'
                  }
                }
              }
            ]
          },
          {
            type: 'pie',
            // zlevel: 2,
            silent: true,
            radius: ['80%', '79%'],
            label: {
              normal: {
                show: false
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: _pie3()
          },
          {
            type: 'pie',
            // zlevel: 2,
            silent: true,
            radius: ['63%', '62%'],
            label: {
              normal: {
                show: false
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: _pie3()
          },
          {
            type: 'pie',
            radius: ['90%', '95%'],
            hoverAnimation: false,
            labelLine: {
              normal: {
                show: false,
                length: 30,
                length2: 55
              },
              emphasis: {
                show: false
              }
            },
            name: '',
            data: [
              {
                name: '',
                value: 0,
                itemStyle: {
                  normal: {
                    color: '#0B4A6B'
                  }
                }
              }
            ]
          },
          {
            stack: 'a',
            type: 'pie',
            radius: ['20%', '80%'],
            roseType: 'area',
            zlevel: 10,
            label: {
              normal: {
                show: true,
                formatter: '{c}',
                textStyle: {
                  fontSize: 12
                },
                position: 'outside'
              },
              emphasis: {
                show: true
              }
            },
            labelLine: {
              normal: {
                show: true,
                length: 20,
                length2: 55
              },
              emphasis: {
                show: false
              }
            },
            data: [
              {
                value: 10,
                name: 'IDS'
              },
              {
                value: 5,
                name: 'VPN'
              },
              {
                value: 15,
                name: '交换机'
              },
              {
                value: 25,
                name: '防火墙'
              },
              {
                value: 20,
                name: 'WAF'
              },
              {
                value: 35,
                name: '堡垒机'
              }
            ]
          }
        ]
      };

      myChart.on('mouseover', function (params) {
        stopTimer();
      });

      myChart.on('mouseout', function (params) {
        startTimer();
      });

      var timer;

      function doing() {
        let option = myChart.getOption();
        option.series[1].startAngle = option.series[1].startAngle - 1;
        option.series[2].startAngle = option.series[2].startAngle + 1;
        // option.series[6].data[0].value = option.series[6].data[0].value + 1;
        myChart.setOption(option);
      }

      function startTimer() {
        timer = setInterval(doing, 100);
      }

      function stopTimer() {
        clearInterval(timer);

        xzTimer = null;
      }

      setTimeout(startTimer, 500);

      function _pie3() {
        let dataArr = [];
        for (var i = 0; i < 100; i++) {
          if (i % 2 === 0) {
            dataArr.push({
              name: (i + 1).toString(),
              value: 25,
              itemStyle: {
                normal: {
                  color: 'rgb(126,190,255)',
                  borderWidth: 0,
                  borderColor: 'rgba(0,0,0,0)'
                }
              }
            });
          } else {
            dataArr.push({
              name: (i + 1).toString(),
              value: 20,
              itemStyle: {
                normal: {
                  color: 'rgba(0,0,0,0)',
                  borderWidth: 0,
                  borderColor: 'rgba(0,0,0,0)'
                }
              }
            });
          }
        }
        return dataArr;
      }
      myChart.setOption(option);
    },
    myChartsByBar(){
      let myChart = echarts.init(document.querySelector('#myChartsByBar'));
      // var myChart = document.getElementById('myChartsByBar');
      // 声明颜色数组
      var myColor = ["#1089E7", "#F57474", "#56D0E3", "#f8b448", "#8B78F6","#1089E7", "#F57474", "#56D0E3", "#F8B448", "#8B78F6"];
      var option = option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          top: "10%",
          left: "22%",
          bottom: "10%",
          containLabel: false
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01],
          show: false
        },
        yAxis: [
          {
            type: "category",
            data: ["HTML5", "CSS3", "javascript", "VUE", "NODE","xxxx","1234","yyyy","ssss","rrrr"],
            // 不显示y轴的线
            axisLine: {
              show: false
            },
            // 不显示刻度
            axisTick: {
              show: false
            },
            // 把刻度标签里面的文字颜色设置为白色
            axisLabel: {
              color: "#fff"
            }
          },
          {
            show: true,
            data: [702, 350, 610, 793, 664, 666, 555, 444, 666, 123],
            // 不显示y轴的线
            axisLine: {
              show: false
            },
            // 不显示刻度
            axisTick: {
              show: false
            },
            axisLabel: {
              textStyle: {
                fontSize: 12,
                color: "#fff"
              }
            }
          }
        ],
        dataZoom: [
          //滑动条
          {
            yAxisIndex: 0, //这里是从X轴的0刻度开始
            show: false, //是否显示滑动条，不影响使用
            // type: "slider", // 这个 dataZoom 组件是 slider 型 dataZoom 组件
            startValue: this.startValue, // 从头开始。
            endValue: this.endValue, // 一次性展示5个。
          },
        ],
        series: [
          {
            name: '条',
            type: 'bar',
            //柱子之间的距离
            barCategoryGap: 50,
            barWidth: 15,
            yAxisIndex: 0,
            center:['50%','50%'],
            itemStyle: {
              normal: {
                barBorderRadius: 20,
                color: function (params) {
                  return myColor[params.dataIndex];
                }
                //渐变色
                // color:new echarts.graphic.LinearGradient(
                //   1, 0, 0, 1,
                //   [
                //     {offset: 0, color: '#F57474'},
                //     {offset: 0.5, color: '#3A8EE6'},
                //     {offset: 0.8, color: '#FAB6B6'},
                //     {offset: 1, color: '#8B78F6'},
                //     {offset: 1, color: '#FFF8B448'}
                //   ]
                // )
              }
            },
            label: {
              normal: {
                show: true,
                position: "inside",
                formatter: "{c}%"

              }
            },
            data: [70, 34, 60, 78, 69, 70, 34, 60, 78, 69],
            animationDuration: 2800,
            animationEasing: "cubicInOut",
          },
          // {
          //   name: '框',
          //   type: 'bar',
          //   barCategoryGap: 50,
          //   barWidth: 18,
          //   yAxisIndex: 1,
          //   itemStyle: {
          //     color: "none",
          //     borderColor: "#00c1de",
          //     borderWidth: 3,
          //     barBorderRadius: 15
          //   },
          //   data: [100, 100, 100, 100, 100],
          // },
        ]
      };
      myChart.setOption(option);
    },
    startInterval(){
      setInterval(()=>{
        if (this.startValue==5){
          this.startValue=0
          this.endValue=4
        }
        this.startValue++
        this.endValue++
        this.myChartsByBar()
      },2000)
    },
    myChartsByPicTwo(){
      // let myChart = echarts.init(document.querySelector('#myChartsByBarTwo'));
      var chartDom = document.getElementById('myChartsByPicTwo');
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        baseOption: {
          timeline: {
            axisType: 'category',
            autoPlay: true,
            show: false,
            playInterval: 5000,
            data: ['数学', '语文', '自然']
          },
          title: {
            top: 30,
            right: 20,
            textStyle: {
              color: '#eee'
            }
          },
          legend: {
            orient: 'vertical',
            symbol: '',
            top: 65,
            right: 15,
            data: ['个人', '班级', '年级'],
            itemGap: 20,
            textStyle: {
              color: '#fff',
              fontSize: 12
            }
          },
          radar: {
            startAngle: 60,
            indicator: [
              {
                name: '运算求解',
                max: 100
              },
              {
                name: '推理运算',
                max: 100
              },
              {
                name: '数学建模',
                max: 100
              },
              {
                name: '空间想象',
                max: 100
              },
              {
                name: '数据处理',
                max: 100
              },
              {
                name: '数学表达',
                max: 100
              }
            ],
            shape: 'polygon',
            splitNumber: 5,
            name: {
              textStyle: {
                fontFamily: 'sc',
                fontSize: 14,
                color: '#fff'
              }
            },

            splitLine: {
              lineStyle: {
                color: 'rgba(109, 205, 230, 0.5)'
              }
            },
            splitArea: {
              show: false
            },
            axisLine: {
              lineStyle: {
                color: 'rgba(238, 197, 102, 0.5)'
              }
            }
          },
          series: [
            {
              name: '个人',
              type: 'radar',
              itemStyle: {
                color: '#6DCDE6'
              },
              areaStyle: {
                opacity: 0.4,
                color: {
                  type: 'radial',
                  x: 0.5,
                  y: 0.5,
                  r: 0.5,
                  colorStops: [
                    {
                      offset: 0,
                      color: '#38A0D6' // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: '#61C3E2' // 100% 处的颜色
                    }
                  ],
                  global: false // 缺省为 false
                }
              }
            },
            {
              name: '班级',
              type: 'radar',
              itemStyle: {
                color: '#FFA53C'
              },
              areaStyle: {
                opacity: 0.4,
                color: {
                  type: 'radial',
                  x: 0.5,
                  y: 0.5,
                  r: 0.5,
                  colorStops: [
                    {
                      offset: 0,
                      color: '#FF457E' // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: '#FFA53C' // 100% 处的颜色
                    }
                  ],
                  global: false // 缺省为 false
                }
              }
            },
            {
              name: '年级',
              type: 'radar',
              itemStyle: {
                color: '#E23AF5'
              },
              areaStyle: {
                opacity: 0.4,
                color: {
                  type: 'radial',
                  x: 0.5,
                  y: 0.5,
                  r: 0.5,
                  colorStops: [
                    {
                      offset: 0,
                      color: '#BB42EF' // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: '#E23AF5' // 100% 处的颜色
                    }
                  ],
                  global: false // 缺省为 false
                }
              }
            }
          ]
        },
        options: [
          {
            title: {
              text: '数学'
            },
            radar: {
              indicator: [
                {
                  name: '运算求解',
                  max: 100
                },
                {
                  name: '推理运算',
                  max: 100
                },
                {
                  name: '数学建模',
                  max: 100
                },
                {
                  name: '空间想象',
                  max: 100
                },
                {
                  name: '数据处理',
                  max: 100
                },
                {
                  name: '数学表达',
                  max: 100
                }
              ]
            },
            series: [
              {
                data: [[55, 91, 56, 80, 48, 62, 22]]
              },
              {
                data: [[26, 37, 27, 73, 27, 13, 41]]
              },
              {
                data: [[91, 45, 95, 82, 34, 23, 71]]
              }
            ]
          },
          {
            title: {
              text: '语文'
            },
            radar: {
              startAngle: 0,
              indicator: [
                {
                  name: '倾听',
                  max: 100
                },
                {
                  name: '发言',
                  max: 100
                },
                {
                  name: '朗读',
                  max: 100
                },
                {
                  name: '合作',
                  max: 100
                }
              ]
            },
            series: [
              {
                data: [[55, 91, 56, 80]]
              },
              {
                data: [[26, 87, 57, 63]]
              },
              {
                data: [[91, 75, 95, 82]]
              }
            ]
          },
          {
            title: {
              text: '自然'
            },
            radar: {
              startAngle: 0,
              indicator: [
                {
                  name: '记录单',
                  max: 100
                },
                {
                  name: '分析结论',
                  max: 100
                },
                {
                  name: '实验方案',
                  max: 100
                },
                {
                  name: '卫生',
                  max: 100
                }
              ]
            },
            series: [
              {
                data: [[55, 91, 56, 80]]
              },
              {
                data: [[26, 67, 97, 73]]
              },
              {
                data: [[91, 65, 95, 82]]
              }
            ]
          }
        ]
      };
      myChart.setOption(option);
    },
    myChartsByBarTwo(){
      var chartDom = document.getElementById('myChartsByBarTwo');
      var myChart = echarts.init(chartDom);
      var option;
      const series = [];
      const centerY = 50; // 原点y轴的单位距离
      const centerYOffset = 5;// 原点偏移
      const centerX = 100 / 3;// 原点x轴的单位距离
      const chartList = [
        {
          value: 50,
          total: 60,
          name: '温度'
        }, {
          value: 50,
          total: 60,
          name: '压力'
        }, {
          value: 50,
          total: 60,
          name: '液位'
        }, {
          value: 50,
          total: 60,
          name: '可燃气体'
        }, {
          value: 50,
          total: 60,
          name: '有毒气体'
        }, {
          value: 50,
          total: 60,
          name: '视频信号'
        }
      ];
      chartList.forEach((item, index) => {
        const radius = 30;
        const borderWidth = 30;
        const titleSize = 20;
        const valueSize = 15;
        const ratio = item.value / item.total * 360;
        const center = [
          centerX * (index % 3) + centerX / 2 + '%',
          centerY * Math.floor(index / 3) + centerY / 2 - centerYOffset + '%'
        ];
        series.push(
          { // 内圆背景
            type: 'pie',
            radius: radius + '%',
            center,
            z: 1,
            itemStyle: {
              color: new echarts.graphic.RadialGradient(0.5, 0.5, 0.8, [{
                offset: 0,
                color: '#092a5d'
              },
                {
                  offset: 0.3,
                  color: '#092a5d'
                },
                {
                  offset: 1,
                  color: '#0e829b'
                }
              ], false),
              label: {
                show: false
              },
              labelLine: {
                show: false
              }
            },
            label: {
              show: false
            },
            tooltip: {
              show: false
            },
            data: [100]
          },
          { //  内圆边框
            type: 'pie',
            radius: [radius + '%', radius - 1 + '%'],
            center,
            // clockWise: false,
            z: 2,
            itemStyle: {
              shadowBlur: 20,
              shadowColor: '#0e829b',
              color: '#0e829b'
            },
            label: {
              show: false
            },
            data: [100]
          },
          { // 进度
            type: 'gauge',
            radius: radius + '%',
            startAngle: 90,
            endAngle: ~ratio + 91,
            center,
            z: 3,
            axisLine: {
              lineStyle: {
                width: borderWidth,
                color: [[1, new echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [
                    { offset: 0, color: '#19f6c0' },
                    { offset: 1, color: '#26dafd' }
                  ]
                )]]
              }
            },
            pointer: {
              show: false
            },
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            },
            detail: {
              valueAnimation: true,
              formatter: () => `${item.value}/${item.total}`,
              offsetCenter: [0, 0],
              fontSize: valueSize,
              fontWeight: 'bolder',
              color: '#1ce9d8'
            },
            title: {
              offsetCenter: [0, '165%'],
              fontSize: titleSize,
              color: '#fff'
            },
            data: [item]
          },
          { // 内圆刻度
            type: 'gauge',
            startAngle: 90,
            endAngle: -270,
            radius: radius + '%',
            z: 4,
            center,
            axisLine: {
              show: false
            },
            pointer: {
              show: false
            },
            axisTick: {
              show: false
            },
            splitLine: {
              distance: -10,
              length: borderWidth,
              lineStyle: {
                color: 'rgba(17,131,167,0.6)',
                width: 3
              }
            },
            axisLabel: {
              show: false
            }
          },
          { // 外圆
            type: 'pie',
            z: 5,
            radius: [radius + 5 + '%', radius + 3 + '%'],
            center,
            // clockWise: false,
            itemStyle: {
              shadowBlur: 20,
              shadowColor: '#0e829b',
              color: '#0e829b'
            },
            label: {
              show: false
            },
            data: [100]
          },
          { // 为了添加点击事件添加遮罩
            type: 'pie',
            z: 6,
            radius: [radius + 5 + '%', 0],
            center,
            // clockWise: false,
            itemStyle: {
              shadowBlur: 20,
              shadowColor: 'transparent',
              color: 'transparent'
            },
            label: {
              show: false
            },
            data: [item]
          }
        );
      });

      option = {

        animation: true,
        series: series
      };

      myChart.setOption(option);
    },
    myChartsByMap(){
      echarts.registerMap("china", china);
      let myChart = echarts.init(document.querySelector('#myChartsByMap'));
      var geoCoordMap = {
        '上海': [121.4648,31.2891],
        '东莞': [113.8953,22.901],
        '东营': [118.7073,37.5513],
        '中山': [113.4229,22.478],
        '临汾': [111.4783,36.1615],
        '临沂': [118.3118,35.2936],
        '丹东': [124.541,40.4242],
        '丽水': [119.5642,28.1854],
        '乌鲁木齐': [87.9236,43.5883],
        '佛山': [112.8955,23.1097],
        '保定': [115.0488,39.0948],
        '兰州': [103.5901,36.3043],
        '包头': [110.3467,41.4899],
        '北京': [116.4551,40.2539],
        '北海': [109.314,21.6211],
        '南京': [118.8062,31.9208],
        '南宁': [108.479,23.1152],
        '南昌': [116.0046,28.6633],
        '南通': [121.1023,32.1625],
        '厦门': [118.1689,24.6478],
        '台州': [121.1353,28.6688],
        '合肥': [117.29,32.0581],
        '呼和浩特': [111.4124,40.4901],
        '咸阳': [108.4131,34.8706],
        '哈尔滨': [127.9688,45.368],
        '唐山': [118.4766,39.6826],
        '嘉兴': [120.9155,30.6354],
        '大同': [113.7854,39.8035],
        '大连': [122.2229,39.4409],
        '天津': [117.4219,39.4189],
        '太原': [112.3352,37.9413],
        '威海': [121.9482,37.1393],
        '宁波': [121.5967,29.6466],
        '宝鸡': [107.1826,34.3433],
        '宿迁': [118.5535,33.7775],
        '常州': [119.4543,31.5582],
        '广州': [113.5107,23.2196],
        '廊坊': [116.521,39.0509],
        '延安': [109.1052,36.4252],
        '张家口': [115.1477,40.8527],
        '徐州': [117.5208,34.3268],
        '德州': [116.6858,37.2107],
        '惠州': [114.6204,23.1647],
        '成都': [103.9526,30.7617],
        '扬州': [119.4653,32.8162],
        '承德': [117.5757,41.4075],
        '拉萨': [91.1865,30.1465],
        '无锡': [120.3442,31.5527],
        '日照': [119.2786,35.5023],
        '昆明': [102.9199,25.4663],
        '杭州': [119.5313,29.8773],
        '枣庄': [117.323,34.8926],
        '柳州': [109.3799,24.9774],
        '株洲': [113.5327,27.0319],
        '武汉': [114.3896,30.6628],
        '汕头': [117.1692,23.3405],
        '江门': [112.6318,22.1484],
        '沈阳': [123.1238,42.1216],
        '沧州': [116.8286,38.2104],
        '河源': [114.917,23.9722],
        '泉州': [118.3228,25.1147],
        '泰安': [117.0264,36.0516],
        '泰州': [120.0586,32.5525],
        '济南': [117.1582,36.8701],
        '济宁': [116.8286,35.3375],
        '海口': [110.3893,19.8516],
        '淄博': [118.0371,36.6064],
        '淮安': [118.927,33.4039],
        '深圳': [114.5435,22.5439],
        '清远': [112.9175,24.3292],
        '温州': [120.498,27.8119],
        '渭南': [109.7864,35.0299],
        '湖州': [119.8608,30.7782],
        '湘潭': [112.5439,27.7075],
        '滨州': [117.8174,37.4963],
        '潍坊': [119.0918,36.524],
        '烟台': [120.7397,37.5128],
        '玉溪': [101.9312,23.8898],
        '珠海': [113.7305,22.1155],
        '盐城': [120.2234,33.5577],
        '盘锦': [121.9482,41.0449],
        '石家庄': [114.4995,38.1006],
        '福州': [119.4543,25.9222],
        '秦皇岛': [119.2126,40.0232],
        '绍兴': [120.564,29.7565],
        '聊城': [115.9167,36.4032],
        '肇庆': [112.1265,23.5822],
        '舟山': [122.2559,30.2234],
        '苏州': [120.6519,31.3989],
        '莱芜': [117.6526,36.2714],
        '菏泽': [115.6201,35.2057],
        '营口': [122.4316,40.4297],
        '葫芦岛': [120.1575,40.578],
        '衡水': [115.8838,37.7161],
        '衢州': [118.6853,28.8666],
        '西宁': [101.4038,36.8207],
        '西安': [109.1162,34.2004],
        '贵阳': [106.6992,26.7682],
        '连云港': [119.1248,34.552],
        '邢台': [114.8071,37.2821],
        '邯郸': [114.4775,36.535],
        '郑州': [113.4668,34.6234],
        '鄂尔多斯': [108.9734,39.2487],
        '重庆': [107.7539,30.1904],
        '金华': [120.0037,29.1028],
        '铜川': [109.0393,35.1947],
        '银川': [106.3586,38.1775],
        '镇江': [119.4763,31.9702],
        '长春': [125.8154,44.2584],
        '长沙': [113.0823,28.2568],
        '长治': [112.8625,36.4746],
        '阳泉': [113.4778,38.0951],
        '青岛': [120.4651,36.3373],
        '韶关': [113.7964,24.7028]
      };

      var XAData = [
        [{name:'西安'}, {name:'北京',value:100}],
        [{name:'西安'}, {name:'上海',value:100}],
        [{name:'西安'}, {name:'广州',value:100}],
        [{name:'西安'}, {name:'西宁',value:100}],
        [{name:'西安'}, {name:'深圳',value:100}],
        [{name:'西安'}, {name:'西安',value:100}],
        [{name:'西安'}, {name:'柳州',value:100}],
        [{name:'西安'}, {name:'衢州',value:100}]
      ];

      var XNData = [
        [{name:'西宁'}, {name:'北京',value:100}],
        [{name:'西宁'}, {name:'上海',value:100}],
        [{name:'西宁'}, {name:'广州',value:100}],
        [{name:'西宁'}, {name:'西安',value:100}],
        [{name:'西宁'}, {name:'银川',value:100}],
        [{name:'西宁'}, {name:'重庆',value:100}],
        [{name:'西宁'}, {name:'青岛',value:100}],
        [{name:'西宁'}, {name:'玉溪',value:100}]
      ];

      var YCData = [
        [{name:'银川'}, {name:'北京',value:100}],
        [{name:'银川'}, {name:'福州',value:100}],
        [{name:'银川'}, {name:'上海',value:100}],
        [{name:'银川'}, {name:'西安',value:100}],
        [{name:'银川'}, {name:'西宁',value:100}],
        [{name:'银川'}, {name:'拉萨',value:100}],
        [{name:'银川'}, {name:'包头',value:100}],
        [{name:'银川'}, {name:'南京',value:100}]
      ];
      var BJData = [
        [{name:'北京'}, {name:'邯郸',value:100}],
        [{name:'北京'}, {name:'汕头',value:100}],
        [{name:'北京'}, {name:'泉州',value:100}],
        [{name:'北京'}, {name:'杭州',value:100}],
        [{name:'北京'}, {name:'西宁',value:100}],
        [{name:'北京'}, {name:'镇江',value:100}],
        [{name:'北京'}, {name:'渭南',value:100}],
        [{name:'北京'}, {name:'淄博',value:100}],
        [{name:'北京'}, {name:'江门',value:100}],
        [{name:'北京'}, {name:'呼和浩特',value:100}],
        [{name:'北京'}, {name:'哈尔滨',value:100}],
        [{name:'北京'}, {name:'鄂尔多斯',value:100}],
        [{name:'北京'}, {name:'昆明',value:100}]

      ];
      var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';
      //var planePath = 'arrow';
      var convertData = function (data) {

        var res = [];
        for (var i = 0; i < data.length; i++) {

          var dataItem = data[i];

          var fromCoord = geoCoordMap[dataItem[0].name];
          var toCoord = geoCoordMap[dataItem[1].name];
          if (fromCoord && toCoord) {
            res.push({
              fromName: dataItem[0].name,
              toName: dataItem[1].name,
              coords: [fromCoord, toCoord],
              value: dataItem[1].value
            });
          }
        }
        return res;

      };

      var color = ['#a6c84c', '#ffa022', '#46bee9'];//航线的颜色
      var series = [];
      [['西安', XAData], ['西宁', XNData], ['银川', YCData],['北京', BJData]].forEach(function (item, i) {
        series.push({
            name: item[0] + ' Top3',
            type: 'lines',
            zlevel: 1,
            effect: {
              show: true,
              period: 6,
              trailLength: 0.7,
              color: 'red',   //arrow箭头的颜色
              symbolSize: 3
            },
            lineStyle: {
              normal: {
                color: color[i],
                width: 0,
                curveness: 0.2
              }
            },
            data: convertData(item[1])
          },
          {
            name: item[0] + ' Top3',
            type: 'lines',
            zlevel: 2,
            symbol: ['none', 'arrow'],
            symbolSize: 10,
            effect: {
              show: true,
              period: 6,
              trailLength: 0,
              symbol: planePath,
              symbolSize: 15
            },
            lineStyle: {
              normal: {
                color: color[i],
                width: 1,
                opacity: 0.6,
                curveness: 0.2
              }
            },
            data: convertData(item[1])
          },
          {
            name: item[0] + ' Top3',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            zlevel: 2,
            rippleEffect: {
              brushType: 'stroke'
            },
            label: {
              normal: {
                show: true,
                position: 'right',
                formatter: '{b}'
              }
            },
            symbolSize: function (val) {
              return val[2] / 8;
            },
            itemStyle: {
              normal: {
                color: color[i],
              },
              emphasis: {
                areaColor: '#2B91B7'
              }
            },
            data: item[1].map(function (dataItem) {
              return {
                name: dataItem[1].name,
                value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
              };
            })
          });
      });
      var option = {
        title : {
          // text: '模拟航线',
          // subtext: '数据纯属虚构',
          left: 'center',
          textStyle : {
            color: '#fff'
          }
        },
        tooltip : {
          trigger: 'item',
          formatter:function(params, ticket, callback){
            if(params.seriesType=="effectScatter") {
              return "线路："+params.data.name+""+params.data.value[2];
            }else if(params.seriesType=="lines"){
              return params.data.fromName+">"+params.data.toName+"<br />"+params.data.value;
            }else{
              return params.name;
            }
          }
        },
        // legend: {
        //   orient: 'vertical',
        //   top: 'bottom',
        //   left: 'right',
        //   data:['西安 Top3', '西宁 Top3', '银川 Top3'],
        //   textStyle: {
        //     color: '#fff'
        //   },
        //   selectedMode: 'multiple'
        // },
        geo: {
          map: 'china',
          label: {
            emphasis: {
              show: true,
              color:'#fff'
            }
          },
          roam: true,
          itemStyle: {
            normal: {
              // areaColor: '#00186E',
              areaColor: 'rgba(238,238,238,0.5)',
              // borderColor: '#195BB9',
              borderColor: '#ffffff',
              borderWidth: 1,
            },
            emphasis: {
              areaColor: '#F1D00A'
            }
          }
        },
        series: series
      };
      myChart.setOption(option);
    }
  },
  mounted() {
    //echarts加载
    this.myChartsByPic();
    this.myChartsByBar();
    this.myChartsByPicTwo();
    this.startInterval();//柱状图定时刷新
    this.myChartsByBarTwo();
    this.myChartsByMap();
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

<style>
  .all{
    background: url("../assets/images/bg.jpg")no-repeat center center;
    /*background-size:100% 100%;*/
    /*background-color: #534a4a;*/
    /*background-color: rgba(120, 179, 38, 0.99);*/
    height: calc(100vh - 84px);
    width: 100%;
    position: absolute;
  }
  .banner{
    position: relative;
    width: 100%;
    height: 100%;
    /*top: -800px;*/
  }
  .el-row {
    margin-bottom: 20px;
  }
  .el-row:last-child {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    /*background: #664978;*/
    /*border: 1px solid rgba(25, 186, 139, 0.17);*/
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .header{
    background-image: url("../assets/images/head_bg.png");
    background-size:100% 100%;
    height: 100px;
    margin-top: -32px;
    text-align: center;
  }
  .header h1{
    color: white;
    height: 100px;
    line-height: 100px;
    font-size: 40px;
  }
  .mycharts{
    position: relative;
    width: 450px;
    border: 1px solid rgba(25, 186, 139, 0.17);
    background: rgba(40, 82, 145, 0.03) url("../assets/images/line.png") repeat top left;
  }
  .mycharts::after{
    position: absolute;
    content: "";
    right: 0;
    top: 0;
    width: 1rem;
    height: 1rem;
    border-top: 3px solid #02a6b5;
    border-right: 3px solid #02a6b5;
  }
  .mycharts::before{
    position: absolute;
    content: "";
    left: 0;
    top: 0;
    width: 1rem;
    height: 1rem;
    border-top: 3px solid #02a6b5;
    border-left: 3px solid #02a6b5;
  }
  .btm{
    position: absolute;
    width: 100%;
    bottom: 0;
    left: 0;
  }
  .mycharts .btm::after{
    position: absolute;
    content: "";
    right: 0;
    bottom: 0;
    width: 1rem;
    height: 1rem;
    border-bottom: 3px solid #02a6b5;
    border-right: 3px solid #02a6b5;
  }
  .mycharts .btm::before{
    position: absolute;
    content: "";
    left: 0;
    bottom: 0;
    width: 1rem;
    height: 1rem;
    border-bottom: 3px solid #02a6b5;
    border-left: 3px solid #02a6b5;
  }
  @keyframes earth-move {
    from {
      transform: scale(0);
    }
    to {
      transform: scale(1);
    }
  }

  .earth-box {
    position: fixed !important;
    left: 50%;
    margin-left: -500px;
    width: 1080px;
    height: 1000px;
    background: transparent;
    z-index: 2;
    transform: scale(0);
    animation: earth-move 1s ease-in-out 1s forwards;
  }

  .earth-box::before {
    content: "";
    position: absolute;
    top: 23%;
    left: 26%;
    width: 48%;
    height: 54%;
    border-radius: 50%;
    box-shadow: 0 0 300px 80px rgba(116, 36, 216, 0.8);
  }
</style>
