$wnd.showcase.runAsyncCallback11("function IEb(){}\nfunction KEb(){}\nfunction DEb(a,b){a.b=b}\nfunction EEb(a){if(a==tEb){return true}gz();return a==wEb}\nfunction FEb(a){if(a==sEb){return true}gz();return a==rEb}\nfunction JEb(a){this.b=(lGb(),gGb).a;this.e=(qGb(),pGb).a;this.a=a}\nfunction BEb(a,b){var c;c=hC(a.fb,153);c.b=b.a;!!c.d&&vzb(c.d,b)}\nfunction CEb(a,b){var c;c=hC(a.fb,153);c.e=b.a;!!c.d&&xzb(c.d,b)}\nfunction GEb(){xEb();zzb.call(this);this.b=(lGb(),gGb);this.c=(qGb(),pGb);(jwb(),this.e)[fbc]=0;this.e[gbc]=0}\nfunction xEb(){xEb=SX;qEb=new IEb;tEb=new IEb;sEb=new IEb;rEb=new IEb;uEb=new IEb;vEb=new IEb;wEb=new IEb}\nfunction yEb(a,b,c){var d;if(c==qEb){if(b==a.a){return}else if(a.a){throw mX(new mXb('Only one CENTER widget may be added'))}}Th(b);yQb(a.j,b);c==qEb&&(a.a=b);d=new JEb(c);b.fb=d;BEb(b,a.b);CEb(b,a.c);AEb(a);Vh(b,a)}\nfunction zEb(a){var b,c,d,e,f,g,h;fQb((jwb(),a.hb),'',Pcc);g=new x3b;h=new IQb(a.j);while(h.b<h.c.c){b=GQb(h);f=hC(b.fb,153).a;d=hC(t$b(P3b(g.d,f)),86);c=!d?1:d.a;e=f==uEb?'north'+c:f==vEb?'south'+c:f==wEb?'west'+c:f==rEb?'east'+c:f==tEb?'linestart'+c:f==sEb?'lineend'+c:O9b;fQb(So(b.hb),Pcc,e);F$b(g,f,DXb(c+1))}}\nfunction AEb(a){var b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r;b=(jwb(),a.d);while(Nxb(b)>0){yo(b,Mxb(b,0))}o=1;e=1;for(i=new IQb(a.j);i.b<i.c.c;){d=GQb(i);f=hC(d.fb,153).a;f==uEb||f==vEb?++o:(f==rEb||f==wEb||f==tEb||f==sEb)&&++e}p=qB(CR,k7b,261,o,0,1);for(g=0;g<o;++g){p[g]=new KEb;p[g].b=$doc.createElement(dbc);uo(b,qwb(p[g].b))}k=0;l=e-1;m=0;q=o-1;c=null;for(h=new IQb(a.j);h.b<h.c.c;){d=GQb(h);j=hC(d.fb,153);r=$doc.createElement(ebc);j.d=r;j.d[Uac]=j.b;j.d.style[Vac]=j.e;j.d[C7b]=j.f;j.d[B7b]=j.c;if(j.a==uEb){mwb(p[m].b,r,p[m].a);uo(r,qwb(d.hb));r[Wbc]=l-k+1;++m}else if(j.a==vEb){mwb(p[q].b,r,p[q].a);uo(r,qwb(d.hb));r[Wbc]=l-k+1;--q}else if(j.a==qEb){c=r}else if(EEb(j.a)){n=p[m];mwb(n.b,r,n.a++);uo(r,qwb(d.hb));r[Qcc]=q-m+1;++k}else if(FEb(j.a)){n=p[m];mwb(n.b,r,n.a);uo(r,qwb(d.hb));r[Qcc]=q-m+1;--l}}if(a.a){n=p[m];mwb(n.b,c,n.a);uo(c,qwb(gh(a.a)))}}\nvar Pcc='cwDockPanel';RX(416,1,N9b);_.Bc=function Heb(){var a,b,c;i$(this.a,(a=new GEb,(jwb(),a.hb).className='cw-DockPanel',a.e[fbc]=4,DEb(a,(lGb(),fGb)),yEb(a,new dDb(Jcc),(xEb(),uEb)),yEb(a,new dDb(Kcc),vEb),yEb(a,new dDb(Lcc),rEb),yEb(a,new dDb(Mcc),wEb),yEb(a,new dDb(Ncc),uEb),yEb(a,new dDb(Occ),vEb),b=new dDb('\\u8FD9\\u4E2A\\u793A\\u4F8B\\u4E2D\\u5728<code>DockPanel<\\/code> \\u7684\\u4E2D\\u95F4\\u4F4D\\u7F6E\\u6709\\u4E00\\u4E2A<code>ScrollPanel<\\/code>\\u3002\\u5982\\u679C\\u5728\\u4E2D\\u95F4\\u653E\\u5165\\u5F88\\u591A\\u5185\\u5BB9\\uFF0C\\u5B83\\u5C31\\u4F1A\\u53D8\\u6210\\u9875\\u9762\\u5185\\u7684\\u53EF\\u6EDA\\u52A8\\u533A\\u57DF\\uFF0C\\u65E0\\u9700\\u4F7F\\u7528IFRAME\\u3002<br><br>\\u6B64\\u5904\\u4F7F\\u7528\\u4E86\\u76F8\\u5F53\\u591A\\u65E0\\u610F\\u4E49\\u7684\\u6587\\u5B57\\uFF0C\\u4E3B\\u8981\\u662F\\u4E3A\\u4E86\\u53EF\\u4EE5\\u6EDA\\u52A8\\u81F3\\u53EF\\u89C6\\u533A\\u57DF\\u7684\\u5E95\\u90E8\\u3002\\u5426\\u5219\\uFF0C\\u60A8\\u6050\\u6015\\u4E0D\\u5F97\\u4E0D\\u628A\\u5B83\\u7F29\\u5230\\u5F88\\u5C0F\\u624D\\u80FD\\u770B\\u5230\\u90A3\\u5C0F\\u5DE7\\u7684\\u6EDA\\u52A8\\u6761\\u3002'),c=new yAb(b),c.hb.style[C7b]='400px',c.hb.style[B7b]='100px',yEb(a,c,qEb),zEb(a),a))};RX(879,253,H7b,GEb);_.gc=function HEb(a){var b;b=tyb(this,a);if(b){a==this.a&&(this.a=null);AEb(this)}return b};var qEb,rEb,sEb,tEb,uEb,vEb,wEb;var DR=XWb(F7b,'DockPanel',879);RX(152,1,{},IEb);var AR=XWb(F7b,'DockPanel/DockLayoutConstant',152);RX(153,1,{153:1},JEb);_.c='';_.f='';var BR=XWb(F7b,'DockPanel/LayoutData',153);RX(261,1,{261:1},KEb);_.a=0;var CR=XWb(F7b,'DockPanel/TmpRow',261);N6b(Bl)(11);\n//# sourceURL=showcase-11.js\n")
