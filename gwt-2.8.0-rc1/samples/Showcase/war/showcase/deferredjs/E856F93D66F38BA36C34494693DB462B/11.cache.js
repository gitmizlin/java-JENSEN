$wnd.showcase.runAsyncCallback11("function Gjc(){}\nfunction Ijc(){}\nfunction Bjc(a,b){a.b=b}\nfunction Cjc(a){if(a==rjc){return true}DB();return a==ujc}\nfunction Djc(a){if(a==qjc){return true}DB();return a==pjc}\nfunction Hjc(a){this.b=(ilc(),dlc).a;this.e=(nlc(),mlc).a;this.a=a}\nfunction Ejc(){vjc();yec.call(this);this.b=(ilc(),dlc);this.c=(nlc(),mlc);this.e[FSc]=0;this.e[GSc]=0}\nfunction zjc(a,b){var c;c=vfb(a.fb,180);c.b=b.a;!!c.d&&(c.d[ESc]=b.a,undefined)}\nfunction Ajc(a,b){var c;c=vfb(a.fb,180);c.e=b.a;!!c.d&&xec(c.d,b)}\nfunction vjc(){vjc=UCb;ojc=new Gjc;rjc=new Gjc;qjc=new Gjc;pjc=new Gjc;sjc=new Gjc;tjc=new Gjc;ujc=new Gjc}\nfunction wjc(a,b,c){var d;if(c==ojc){if(b==a.a){return}else if(a.a){throw oCb(new kCc('Only one CENTER widget may be added'))}}Qh(b);uvc(a.j,b);c==ojc&&(a.a=b);d=new Hjc(c);b.fb=d;zjc(b,a.b);Ajc(b,a.c);yjc(a);Sh(b,a)}\nfunction xjc(a){var b,c,d,e,f,g,h;bvc(a.hb,'',wUc);g=new vKc;h=new Evc(a.j);while(h.b<h.c.c){b=Cvc(h);f=vfb(b.fb,180).a;d=vfb(rFc(NKc(g.d,f)),113);c=!d?1:d.a;e=f==sjc?'north'+c:f==tjc?'south'+c:f==ujc?'west'+c:f==pjc?'east'+c:f==rjc?'linestart'+c:f==qjc?'lineend'+c:nRc;bvc(So(b.hb),wUc,e);DFc(g,f,BCc(c+1))}}\nfunction yjc(a){var b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r;b=a.d;while(b.children.length>0){vo(b,b.children[0])}o=1;e=1;for(i=new Evc(a.j);i.b<i.c.c;){d=Cvc(i);f=vfb(d.fb,180).a;f==sjc||f==tjc?++o:(f==pjc||f==ujc||f==rjc||f==qjc)&&++e}p=Eeb(Ewb,jOc,288,o,0,1);for(g=0;g<o;++g){p[g]=new Ijc;p[g].b=Wo($doc,CSc);ro(b,Ebc(p[g].b))}k=0;l=e-1;m=0;q=o-1;c=null;for(h=new Evc(a.j);h.b<h.c.c;){d=Cvc(h);j=vfb(d.fb,180);r=Wo($doc,DSc);j.d=r;j.d[ESc]=j.b;j.d.style[tSc]=j.e;j.d[AOc]=j.f;j.d[zOc]=j.c;if(j.a==sjc){Abc(p[m].b,r,p[m].a);ro(r,Ebc(d.hb));r[MTc]=l-k+1;++m}else if(j.a==tjc){Abc(p[q].b,r,p[q].a);ro(r,Ebc(d.hb));r[MTc]=l-k+1;--q}else if(j.a==ojc){c=r}else if(Cjc(j.a)){n=p[m];Abc(n.b,r,n.a++);ro(r,Ebc(d.hb));r[xUc]=q-m+1;++k}else if(Djc(j.a)){n=p[m];Abc(n.b,r,n.a);ro(r,Ebc(d.hb));r[xUc]=q-m+1;--l}}if(a.a){n=p[m];Abc(n.b,c,n.a);ro(c,Ebc(a.a.hb))}}\nvar wUc='cwDockPanel';TCb(445,1,mRc);_.Bc=function KVb(){var a,b,c;kFb(this.a,(a=new Ejc,a.hb.className='cw-DockPanel',a.e[FSc]=4,Bjc(a,(ilc(),clc)),wjc(a,new bic('This is the first north component'),(vjc(),sjc)),wjc(a,new bic('This is the first south component'),tjc),wjc(a,new bic('This is the east component'),pjc),wjc(a,new bic('This is the west component'),ujc),wjc(a,new bic('This is the second north component'),sjc),wjc(a,new bic('This is the second south component'),tjc),b=new bic(\"This is a <code>ScrollPanel<\\/code> contained at the center of a <code>DockPanel<\\/code>.  By putting some fairly large contents in the middle and setting its size explicitly, it becomes a scrollable area within the page, but without requiring the use of an IFRAME.<br><br>Here's quite a bit more meaningless text that will serve primarily to make this thing scroll off the bottom of its visible area.  Otherwise, you might have to make it really, really small in order to see the nifty scroll bars!\"),c=new xfc(b),c.hb.style[AOc]='400px',c.hb.style[zOc]='100px',wjc(a,c,ojc),xjc(a),a))};TCb(909,280,HOc,Ejc);_.gc=function Fjc(a){var b;b=vdc(this,a);if(b){a==this.a&&(this.a=null);yjc(this)}return b};var ojc,pjc,qjc,rjc,sjc,tjc,ujc;var Fwb=VBc(EOc,'DockPanel',909);TCb(179,1,{},Gjc);var Cwb=VBc(EOc,'DockPanel/DockLayoutConstant',179);TCb(180,1,{180:1},Hjc);_.c='';_.f='';var Dwb=VBc(EOc,'DockPanel/LayoutData',180);TCb(288,1,{288:1},Ijc);_.a=0;var Ewb=VBc(EOc,'DockPanel/TmpRow',288);LNc(yl)(11);\n//# sourceURL=showcase-11.js\n")
