$wnd.showcase.runAsyncCallback24("function Vcb(a){this.a=a}\nfunction Xcb(a){this.a=a}\nfunction Zcb(a){this.a=a}\nfunction cdb(a,b){this.a=a;this.b=b}\nfunction Uo(a,b){a.remove(b)}\nfunction CGb(a){return ivb(),a.hb}\nfunction GGb(a,b){zGb(a,b);Uo((ivb(),a.hb),b)}\nfunction _ub(){var a;if(!Yub||cvb()){a=new y2b;bvb(a);Yub=a}return Yub}\nfunction cvb(){var a=$doc.cookie;if(a!=Zub){Zub=a;return true}else{return false}}\nfunction dvb(a){$ub&&(a=encodeURIComponent(a));$doc.cookie=a+'=;expires=Fri, 02-Jan-1970 00:00:00 GMT'}\nfunction Scb(a){var b,c,d,e;if(CGb(a.c).options.length<1){LIb(a.a,'');LIb(a.b,'');return}e=CGb(a.c).selectedIndex;b=DGb(a.c,e);c=(d=_ub(),BB(b==null?uZb(Q2b(d.d,null)):e3b(d.e,b)));LIb(a.a,b);LIb(a.b,c)}\nfunction Rcb(a,b){var c,d,e,f,g,h;gh(a.c).options.length=0;h=0;e=new I$b(_ub());for(d=(g=e.a.Eg().fc(),new N$b(g));d.a.xf();){c=(f=xB(d.a.yf(),36),BB(f.Kg()));yGb(a.c,c);TWb(c,b)&&(h=gh(a.c).options.length-1)}um((nm(),mm),new cdb(a,h))}\nfunction bvb(b){var c=$doc.cookie;if(c&&c!=''){var d=c.split('; ');for(var e=d.length-1;e>=0;--e){var f,g;var h=d[e].indexOf('=');if(h==-1){f=d[e];g=''}else{f=d[e].substring(0,h);g=d[e].substring(h+1)}if($ub){try{f=decodeURIComponent(f)}catch(a){}try{g=decodeURIComponent(g)}catch(a){}}b.Gg(f,g)}}}\nfunction Qcb(a){var b,c,d;c=new HEb(3,3);a.c=new IGb;b=new nyb('Delete');Fh((ivb(),b.hb),Qbc,true);$Db(c,0,0,'<b><b>Existing Cookies:<\\/b><\\/b>');bEb(c,0,1,a.c);bEb(c,0,2,b);a.a=new UIb;$Db(c,1,0,'<b><b>Name:<\\/b><\\/b>');bEb(c,1,1,a.a);a.b=new UIb;d=new nyb('Set Cookie');Fh(d.hb,Qbc,true);$Db(c,2,0,'<b><b>Value:<\\/b><\\/b>');bEb(c,2,1,a.b);bEb(c,2,2,d);Mh(d,new Vcb(a),(It(),It(),Ht));Mh(a.c,new Xcb(a),(Bt(),Bt(),At));Mh(b,new Zcb(a),(null,Ht));Rcb(a,null);return c}\nXW(455,1,G8b,Vcb);_.Sc=function Wcb(a){var b,c,d;c=HIb(this.a.a);d=HIb(this.a.b);b=new nA(tW(zW((new lA).q.getTime()),Tcc));if((QWb(),c).length<1){$wnd.alert('You must specify a cookie name');return}evb(c,d,b);Rcb(this.a,c)};var dM=YVb(V8b,'CwCookies/1',455);XW(456,1,H8b,Xcb);_.Rc=function Ycb(a){Scb(this.a)};var eM=YVb(V8b,'CwCookies/2',456);XW(457,1,G8b,Zcb);_.Sc=function $cb(a){var b,c;c=gh(this.a.c).selectedIndex;if(c>-1&&c<gh(this.a.c).options.length){b=DGb(this.a.c,c);dvb(b);GGb(this.a.c,c);Scb(this.a)}};var fM=YVb(V8b,'CwCookies/3',457);XW(458,1,P8b);_.Bc=function bdb(){kZ(this.b,Qcb(this.a))};XW(459,1,{},cdb);_.Dc=function ddb(){this.b<gh(this.a.c).options.length&&HGb(this.a.c,this.b);Scb(this.a)};_.b=0;var hM=YVb(V8b,'CwCookies/5',459);var Yub=null,Zub;O5b(Bl)(24);\n//# sourceURL=showcase-24.js\n")