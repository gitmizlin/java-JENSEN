$wnd.showcase.runAsyncCallback1("function Ybb(a){var b,c;b=BO(gbc(a.a,voc),5);if(b==null){c=ON(IN(w6,1),ujc,2,6,['bleu','rouge','jaune','vert']);jbc(a.a,voc,c);return c}else{return b}}\nfunction Zbb(a){var b,c;b=BO(gbc(a.a,woc),5);if(b==null){c=ON(IN(w6,1),ujc,2,6,['Base-ball',xoc,'Football','Hockey','Soccer',yoc]);jbc(a.a,woc,c);return c}else{return b}}\nfunction zub(a){var b,c,d,e,f,g,h,i;i=new T0b;Q0b(i,new CPb('<b>S\\xE9lectionnez votre couleur pr\\xE9f\\xE9r\\xE9e:<\\/b>'));c=Ybb(a.a);for(e=0;e<c.length;e++){b=c[e];f=new TXb(nmc,b);$Lb(f,'cwRadioButton-color-'+b);e==2&&(f.c.disabled=true,undefined,sh(f,Ah((MIb(),f.hb))+'-'+Nmc,true));Q0b(i,f)}Q0b(i,new CPb('<br><b>S\\xE9lectionnez votre sport pr\\xE9f\\xE9r\\xE9:<\\/b>'));h=Zbb(a.a);for(d=0;d<h.length;d++){g=h[d];f=new TXb('sport',g);$Lb(f,'cwRadioButton-sport-'+C8b(g,' ',''));d==2&&_Lb(f,(f7b(),f7b(),true));Q0b(i,f)}return i}\nvar voc='cwRadioButtonColors',woc='cwRadioButtonSports';z8(400,1,Bmc);_.Bc=function Eub(){Oab(this.b,zub(this.a))};qjc(Bl)(1);\n//# sourceURL=showcase-1.js\n")
