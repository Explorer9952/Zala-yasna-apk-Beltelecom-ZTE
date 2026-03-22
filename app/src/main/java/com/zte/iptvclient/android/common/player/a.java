package com.zte.iptvclient.android.common.player;

import android.text.TextUtils;
import com.video.androidsdk.common.BaseXMLParser;
import com.video.androidsdk.service.comm.ParamConst;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/* compiled from: AdVodPlayRspXMLParser.java */
/* loaded from: classes.dex */
public class a extends BaseXMLParser {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.j.e f4849a = null;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.j.d f4850b = null;

    /* renamed from: c, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.j.d f4851c = null;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.j.b f4852d = null;
    private com.zte.iptvclient.android.common.player.j.c e = null;
    private com.zte.iptvclient.android.common.player.j.a f = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        super.endElement(str, str2, str3);
        String sb = this.sbTagValue.toString();
        if ("VodList".equals(this.mstrTagLevel1Name)) {
            if ("VodList".equals(this.mstrTagLevel1Name)) {
                if (str2.equals("Total_ContentLengthB")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4849a.c(0);
                    } else {
                        this.f4849a.c(Integer.parseInt(sb));
                    }
                }
                if (str2.equals("Total_ContentLengthE")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4849a.d(0);
                    } else {
                        this.f4849a.d(Integer.parseInt(sb));
                    }
                }
                if (str2.equals(ParamConst.SEARCH_REQ_SHOWTIME)) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4849a.b(0);
                    } else {
                        this.f4849a.b(Integer.parseInt(sb));
                    }
                }
                if (str2.equals("CloseTime")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4849a.a(0);
                        return;
                    } else {
                        this.f4849a.a(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("Vod")) {
                    this.f4849a.h().add(this.f4850b);
                    return;
                }
                if ("Vod".equals(this.mstrTagLevel2Name)) {
                    if (str2.equals("ContentCode")) {
                        this.f4850b.a(sb);
                        return;
                    }
                    if (str2.equals("OrderCode")) {
                        this.f4850b.b(sb);
                        return;
                    }
                    if (str2.equals("Position")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.i(0);
                            return;
                        } else {
                            this.f4850b.i(Integer.parseInt(sb));
                            return;
                        }
                    }
                    if (str2.equals("PlayNum")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.h(0);
                            return;
                        } else {
                            this.f4850b.h(Integer.parseInt(sb));
                            return;
                        }
                    }
                    if (str2.equals("BonusFlag")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.c(0);
                            return;
                        } else {
                            this.f4850b.c(Integer.parseInt(sb));
                            return;
                        }
                    }
                    if (str2.equals("Bonus")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.b(0);
                            return;
                        } else {
                            this.f4850b.b(Integer.parseInt(sb));
                            return;
                        }
                    }
                    if (str2.equals("ContentLength")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.d(0);
                            return;
                        } else {
                            this.f4850b.d(Integer.parseInt(sb));
                            return;
                        }
                    }
                    if (str2.equals("VodStreamType")) {
                        if (TextUtils.isEmpty(sb)) {
                            this.f4850b.j(0);
                            return;
                        } else {
                            this.f4850b.j(Integer.parseInt(sb));
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if ("InsertList".equals(this.mstrTagLevel1Name)) {
            if (str2.equals("InsertVod")) {
                this.f4849a.i().add(this.f4851c);
                return;
            }
            if ("InsertVod".equals(this.mstrTagLevel2Name)) {
                if (str2.equals("ContentCode")) {
                    this.f4851c.a(sb);
                    return;
                }
                if (str2.equals("OrderCode")) {
                    this.f4851c.b(sb);
                    return;
                }
                if (str2.equals("PlayNum")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.h(0);
                        return;
                    } else {
                        this.f4851c.h(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("Position")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.i(0);
                        return;
                    } else {
                        this.f4851c.i(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("ContentLength")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.d(0);
                        return;
                    } else {
                        this.f4851c.d(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("Total_ContentLength")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.a(0);
                        return;
                    } else {
                        this.f4851c.a(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals(ParamConst.SEARCH_REQ_SHOWTIME)) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.g(0);
                        return;
                    } else {
                        this.f4851c.g(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("CloseTime")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.e(0);
                        return;
                    } else {
                        this.f4851c.e(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("Offset")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.f(0);
                        return;
                    } else {
                        this.f4851c.f(Integer.parseInt(sb));
                        return;
                    }
                }
                if (str2.equals("VodStreamType")) {
                    if (TextUtils.isEmpty(sb)) {
                        this.f4851c.j(0);
                        return;
                    } else {
                        this.f4851c.j(Integer.parseInt(sb));
                        return;
                    }
                }
                return;
            }
            return;
        }
        if ("PauseList".equals(this.mstrTagLevel1Name)) {
            if (str2.equals("PausePic")) {
                this.f4849a.c().add(this.f4852d);
            } else {
                if ("PausePic".equals(this.mstrTagLevel2Name)) {
                    if (str2.equals("BigPicURL")) {
                        this.f4852d.a(sb);
                    } else if (str2.equals("MidPicURL")) {
                        this.f4852d.b(sb);
                    } else if (str2.equals("SmallPicURL")) {
                        this.f4852d.c(sb);
                    }
                }
                if ("PauseVod".equals(this.mstrTagLevel2Name)) {
                    if (str2.equals("ContentCode")) {
                        this.e.a(sb);
                    } else if (str2.equals("OrderCode")) {
                        this.e.b(sb);
                    }
                }
            }
            if (str2.equals("PauseVod")) {
                this.f4849a.d().add(this.e);
                return;
            } else {
                if ("Vod".equals(this.mstrTagLevel2Name) && str2.equals("ContentCode")) {
                    this.e.a(sb);
                    return;
                }
                return;
            }
        }
        if ("PictureList".equals(this.mstrTagLevel1Name)) {
            if (str2.equals("Picture")) {
                this.f4849a.b().add(this.f);
            }
            if ("Picture".equals(this.mstrTagLevel2Name)) {
                if (str2.equals("Url")) {
                    this.f.d(sb);
                    return;
                }
                if (str2.equals("Offset")) {
                    this.f.b(sb);
                } else if (str2.equals("Duration")) {
                    this.f.a(sb);
                } else if (str2.equals("Position")) {
                    this.f.c(sb);
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
        this.f4849a = new com.zte.iptvclient.android.common.player.j.e();
    }

    @Override // com.video.androidsdk.common.BaseXMLParser, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        if (str2.equals("VodList")) {
            this.mstrTagLevel1Name = str2;
            return;
        }
        if (str2.equals("Vod")) {
            this.mstrTagLevel2Name = str2;
            this.f4850b = new com.zte.iptvclient.android.common.player.j.d();
            return;
        }
        if (str2.equals("PauseList")) {
            this.mstrTagLevel1Name = str2;
            return;
        }
        if (str2.equals("PausePic")) {
            this.mstrTagLevel2Name = str2;
            this.f4852d = new com.zte.iptvclient.android.common.player.j.b();
            return;
        }
        if (str2.equals("PauseVod")) {
            this.mstrTagLevel2Name = str2;
            this.e = new com.zte.iptvclient.android.common.player.j.c();
            return;
        }
        if (str2.equals("PictureList")) {
            this.mstrTagLevel1Name = str2;
            return;
        }
        if (str2.equals("Picture")) {
            this.mstrTagLevel2Name = str2;
            this.f = new com.zte.iptvclient.android.common.player.j.a();
        } else if (str2.equals("InsertList")) {
            this.mstrTagLevel1Name = str2;
        } else if (str2.equals("InsertVod")) {
            this.mstrTagLevel2Name = str2;
            this.f4851c = new com.zte.iptvclient.android.common.player.j.d();
        }
    }

    @Override // com.video.androidsdk.common.BaseXMLParser
    public com.zte.iptvclient.android.common.player.j.e getResult() {
        return this.f4849a;
    }
}
