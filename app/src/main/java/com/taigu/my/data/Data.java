package com.taigu.my.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class Data {


    private int code;
    private String msg;
    private DataBean data;

    public static Data objectFromData(String str) {

        return new Gson().fromJson(str, Data.class);
    }

    public static Data objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Data.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Data> arrayDataFromData(String str) {

        Type listType = new TypeToken<ArrayList<Data>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Data> arrayDataFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Data>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int stateCode;
        private String message;
        private ReturnDataBean returnData;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getStateCode() {
            return stateCode;
        }

        public void setStateCode(int stateCode) {
            this.stateCode = stateCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ReturnDataBean getReturnData() {
            return returnData;
        }

        public void setReturnData(ReturnDataBean returnData) {
            this.returnData = returnData;
        }

        public static class ReturnDataBean {
            private boolean hasMore;
            private DefaultParametersBean defaultParameters;
            private int page;
            private List<ComicsBean> comics;
            private List<SpinnerListBean> spinnerList;

            public static ReturnDataBean objectFromData(String str) {

                return new Gson().fromJson(str, ReturnDataBean.class);
            }

            public static ReturnDataBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ReturnDataBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ReturnDataBean> arrayReturnDataBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ReturnDataBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ReturnDataBean> arrayReturnDataBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ReturnDataBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public DefaultParametersBean getDefaultParameters() {
                return defaultParameters;
            }

            public void setDefaultParameters(DefaultParametersBean defaultParameters) {
                this.defaultParameters = defaultParameters;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public List<ComicsBean> getComics() {
                return comics;
            }

            public void setComics(List<ComicsBean> comics) {
                this.comics = comics;
            }

            public List<SpinnerListBean> getSpinnerList() {
                return spinnerList;
            }

            public void setSpinnerList(List<SpinnerListBean> spinnerList) {
                this.spinnerList = spinnerList;
            }

            public static class DefaultParametersBean {
                private int defaultSelection;
                private int defaultArgCon;
                private String defaultConTagType;

                public static DefaultParametersBean objectFromData(String str) {

                    return new Gson().fromJson(str, DefaultParametersBean.class);
                }

                public static DefaultParametersBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), DefaultParametersBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<DefaultParametersBean> arrayDefaultParametersBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DefaultParametersBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<DefaultParametersBean> arrayDefaultParametersBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<DefaultParametersBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getDefaultSelection() {
                    return defaultSelection;
                }

                public void setDefaultSelection(int defaultSelection) {
                    this.defaultSelection = defaultSelection;
                }

                public int getDefaultArgCon() {
                    return defaultArgCon;
                }

                public void setDefaultArgCon(int defaultArgCon) {
                    this.defaultArgCon = defaultArgCon;
                }

                public String getDefaultConTagType() {
                    return defaultConTagType;
                }

                public void setDefaultConTagType(String defaultConTagType) {
                    this.defaultConTagType = defaultConTagType;
                }
            }

            public static class ComicsBean {
                private int newestChapter;
                private String cover;
                private String name;
                private int comicId;
                private String description;
                private int flag;
                private String author;
                private List<String> tags;

                public static ComicsBean objectFromData(String str) {

                    return new Gson().fromJson(str, ComicsBean.class);
                }

                public static ComicsBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ComicsBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ComicsBean> arrayComicsBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ComicsBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ComicsBean> arrayComicsBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ComicsBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getNewestChapter() {
                    return newestChapter;
                }

                public void setNewestChapter(int newestChapter) {
                    this.newestChapter = newestChapter;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getComicId() {
                    return comicId;
                }

                public void setComicId(int comicId) {
                    this.comicId = comicId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getFlag() {
                    return flag;
                }

                public void setFlag(int flag) {
                    this.flag = flag;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public List<String> getTags() {
                    return tags;
                }

                public void setTags(List<String> tags) {
                    this.tags = tags;
                }
            }

            public static class SpinnerListBean {
                private int argCon;
                private String name;
                private String conTag;

                public static SpinnerListBean objectFromData(String str) {

                    return new Gson().fromJson(str, SpinnerListBean.class);
                }

                public static SpinnerListBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), SpinnerListBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<SpinnerListBean> arraySpinnerListBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<SpinnerListBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<SpinnerListBean> arraySpinnerListBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<SpinnerListBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getArgCon() {
                    return argCon;
                }

                public void setArgCon(int argCon) {
                    this.argCon = argCon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getConTag() {
                    return conTag;
                }

                public void setConTag(String conTag) {
                    this.conTag = conTag;
                }
            }
        }
    }
}
