package com.example.administrator.nestword;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

class WeathBean {

    /**
     * error_code : 0
     * reason : Succes
     * result : {"isForeign":0,"life":{"date":"2017-7-18","info":{"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","您将感到些燥热，建议您在适当的时候开启制冷空调来降低温度，以免中暑。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较不宜","天气较好，无雨水困扰，但考虑气温很高，请注意适当减少运动时间并降低运动强度，运动后及时补充水分。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]}},"pm25":{"cityName":"武汉","dateTime":"2017年07月18日15时","key":"Wuhan","pm25":{"curPm":"34","des":"空气很好，可以外出活动","level":"1","pm10":"23","pm25":"9","quality":"优"},"show_desc":"0"},"realtime":{"city_code":"101200101","city_name":"武汉","dataUptime":"1500365778","date":"2017-07-18","moon":"六月廿五","time":"16:00:00","weather":{"humidity":"52","img":"1","info":"多云","temperature":"35"},"week":"2","wind":{"direct":"南风","power":"2级"}},"weather":[{"date":"2017-07-18","info":{"day":["1","多云","35","","微风","05:33"],"night":["1","多云","28","","微风","19:26"]},"nongli":"六月廿五","week":"二"},{"date":"2017-07-19","info":{"dawn":["1","多云","28","无持续风向","微风","19:26"],"day":["1","多云","35","","微风","05:34"],"night":["1","多云","27","","微风","19:25"]},"nongli":"六月廿六","week":"三"},{"date":"2017-07-20","info":{"dawn":["1","多云","27","无持续风向","微风","19:25"],"day":["1","多云","35","","微风","05:35"],"night":["1","多云","28","","微风","19:25"]},"nongli":"六月廿七","week":"四"},{"date":"2017-07-21","info":{"dawn":["1","多云","28","无持续风向","微风","19:25"],"day":["1","多云","35","","微风","05:35"],"night":["0","晴","27","","微风","19:24"]},"nongli":"六月廿八","week":"五"},{"date":"2017-07-22","info":{"dawn":["0","晴","27","无持续风向","微风","19:24"],"day":["0","晴","36","","微风","05:36"],"night":["0","晴","27","","微风","19:24"]},"nongli":"六月廿九","week":"六"},{"date":"2017-07-23","info":{"day":["0","晴","37","西南风","4级","07:30"],"night":["0","晴","27","西南风","4级","19:30"]},"nongli":"闰六月初一","week":"日"},{"date":"2017-07-24","info":{"day":["0","晴","37","西南风","微风","07:30"],"night":["0","晴","28","西南风","微风","19:30"]},"nongli":"闰六月初二","week":"一"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * isForeign : 0
         * life : {"date":"2017-7-18","info":{"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","您将感到些燥热，建议您在适当的时候开启制冷空调来降低温度，以免中暑。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较不宜","天气较好，无雨水困扰，但考虑气温很高，请注意适当减少运动时间并降低运动强度，运动后及时补充水分。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]}}
         * pm25 : {"cityName":"武汉","dateTime":"2017年07月18日15时","key":"Wuhan","pm25":{"curPm":"34","des":"空气很好，可以外出活动","level":"1","pm10":"23","pm25":"9","quality":"优"},"show_desc":"0"}
         * realtime : {"city_code":"101200101","city_name":"武汉","dataUptime":"1500365778","date":"2017-07-18","moon":"六月廿五","time":"16:00:00","weather":{"humidity":"52","img":"1","info":"多云","temperature":"35"},"week":"2","wind":{"direct":"南风","power":"2级"}}
         * weather : [{"date":"2017-07-18","info":{"day":["1","多云","35","","微风","05:33"],"night":["1","多云","28","","微风","19:26"]},"nongli":"六月廿五","week":"二"},{"date":"2017-07-19","info":{"dawn":["1","多云","28","无持续风向","微风","19:26"],"day":["1","多云","35","","微风","05:34"],"night":["1","多云","27","","微风","19:25"]},"nongli":"六月廿六","week":"三"},{"date":"2017-07-20","info":{"dawn":["1","多云","27","无持续风向","微风","19:25"],"day":["1","多云","35","","微风","05:35"],"night":["1","多云","28","","微风","19:25"]},"nongli":"六月廿七","week":"四"},{"date":"2017-07-21","info":{"dawn":["1","多云","28","无持续风向","微风","19:25"],"day":["1","多云","35","","微风","05:35"],"night":["0","晴","27","","微风","19:24"]},"nongli":"六月廿八","week":"五"},{"date":"2017-07-22","info":{"dawn":["0","晴","27","无持续风向","微风","19:24"],"day":["0","晴","36","","微风","05:36"],"night":["0","晴","27","","微风","19:24"]},"nongli":"六月廿九","week":"六"},{"date":"2017-07-23","info":{"day":["0","晴","37","西南风","4级","07:30"],"night":["0","晴","27","西南风","4级","19:30"]},"nongli":"闰六月初一","week":"日"},{"date":"2017-07-24","info":{"day":["0","晴","37","西南风","微风","07:30"],"night":["0","晴","28","西南风","微风","19:30"]},"nongli":"闰六月初二","week":"一"}]
         */

        private int isForeign;
        private LifeBean life;
        private Pm25BeanX pm25;
        private RealtimeBean realtime;
        private List<WeatherBeanX> weather;

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25BeanX getPm25() {
            return pm25;
        }

        public void setPm25(Pm25BeanX pm25) {
            this.pm25 = pm25;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<WeatherBeanX> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBeanX> weather) {
            this.weather = weather;
        }

        public static class LifeBean {
            /**
             * date : 2017-7-18
             * info : {"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","您将感到些燥热，建议您在适当的时候开启制冷空调来降低温度，以免中暑。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较不宜","天气较好，无雨水困扰，但考虑气温很高，请注意适当减少运动时间并降低运动强度，运动后及时补充水分。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]}
             */

            private String date;
            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                private List<String> chuanyi;
                private List<String> ganmao;
                private List<String> kongtiao;
                private List<String> xiche;
                private List<String> yundong;
                private List<String> ziwaixian;

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }
            }
        }

        public static class Pm25BeanX {
            /**
             * cityName : 武汉
             * dateTime : 2017年07月18日15时
             * key : Wuhan
             * pm25 : {"curPm":"34","des":"空气很好，可以外出活动","level":"1","pm10":"23","pm25":"9","quality":"优"}
             * show_desc : 0
             */

            private String cityName;
            private String dateTime;
            private String key;
            private Pm25Bean pm25;
            private String show_desc;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public static class Pm25Bean {
                /**
                 * curPm : 34
                 * des : 空气很好，可以外出活动
                 * level : 1
                 * pm10 : 23
                 * pm25 : 9
                 * quality : 优
                 */

                private String curPm;
                private String des;
                private String level;
                private String pm10;
                private String pm25;
                private String quality;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }
            }
        }

        public static class RealtimeBean {
            /**
             * city_code : 101200101
             * city_name : 武汉
             * dataUptime : 1500365778
             * date : 2017-07-18
             * moon : 六月廿五
             * time : 16:00:00
             * weather : {"humidity":"52","img":"1","info":"多云","temperature":"35"}
             * week : 2
             * wind : {"direct":"南风","power":"2级"}
             */

            private String city_code;
            private String city_name;
            private String dataUptime;
            private String date;
            private String moon;
            private String time;
            private WeatherBean weather;
            private String week;
            private WindBean wind;

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class WeatherBean {
                /**
                 * humidity : 52
                 * img : 1
                 * info : 多云
                 * temperature : 35
                 */

                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }

            public static class WindBean {
                /**
                 * direct : 南风
                 * power : 2级
                 */

                private String direct;
                private String power;

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }
            }
        }

        static class WeatherBeanX {
            /**
             * date : 2017-07-18
             * info : {"day":["1","多云","35","","微风","05:33"],"night":["1","多云","28","","微风","19:26"]}
             * nongli : 六月廿五
             * week : 二
             */

            private String date;
            private InfoBeanX info;
            private String nongli;
            private String week;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public static class InfoBeanX {
                private List<String> day;
                private List<String> night;

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}
