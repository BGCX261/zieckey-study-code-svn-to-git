#############################################################################
# Makefile for building: unnamed
# Generated by qmake (1.07a) (Qt 3.3.8) on: Mon Sep 24 12:07:40 2007
# Project:  unnamed.pro
# Template: app
# Command: $(QMAKE) -o Makefile unnamed.pro
#############################################################################

####### Compiler, tools and options

CC       = gcc
CXX      = g++
LEX      = flex
YACC     = yacc
CFLAGS   = -pipe -Wall -W -O2 -g -pipe -Wall -Wp,-D_FORTIFY_SOURCE=2 -fexceptions -fstack-protector --param=ssp-buffer-size=4 -m32 -march=i386 -mtune=generic -fasynchronous-unwind-tables  -DQT_NO_DEBUG -DQT_SHARED -DQT_TABLET_SUPPORT -DQT_THREAD_SUPPORT
CXXFLAGS = -pipe -Wall -W -O2 -g -pipe -Wall -Wp,-D_FORTIFY_SOURCE=2 -fexceptions -fstack-protector --param=ssp-buffer-size=4 -m32 -march=i386 -mtune=generic -fasynchronous-unwind-tables  -DQT_NO_DEBUG -DQT_SHARED -DQT_TABLET_SUPPORT -DQT_THREAD_SUPPORT
LEXFLAGS = 
YACCFLAGS= -d
INCPATH  = -I/usr/lib/qt-3.3/mkspecs/default -I. -I$(QTDIR)/include -I.ui/ -I. -I.moc/
LINK     = g++
LFLAGS   = 
LIBS     = $(SUBLIBS) -L$(QTDIR)/lib -lqt-mt -lXext -lX11 -lm
AR       = ar cqs
RANLIB   = 
MOC      = $(QTDIR)/bin/moc
UIC      = $(QTDIR)/bin/uic
QMAKE    = qmake
TAR      = tar -cf
GZIP     = gzip -9f
COPY     = cp -f
COPY_FILE= $(COPY)
COPY_DIR = $(COPY) -r
INSTALL_FILE= $(COPY_FILE)
INSTALL_DIR = $(COPY_DIR)
DEL_FILE = rm -f
SYMLINK  = ln -sf
DEL_DIR  = rmdir
MOVE     = mv -f
CHK_DIR_EXISTS= test -d
MKDIR    = mkdir -p

####### Output directory

OBJECTS_DIR = .obj/

####### Files

HEADERS = 
SOURCES = main.cpp
OBJECTS = .obj/main.o \
		.obj/cmaindialog.o \
		.obj/cfinddialog.o
FORMS = cmaindialog.ui \
		cfinddialog.ui
UICDECLS = .ui/cmaindialog.h \
		.ui/cfinddialog.h
UICIMPLS = .ui/cmaindialog.cpp \
		.ui/cfinddialog.cpp
SRCMOC   = .moc/moc_cmaindialog.cpp \
		.moc/moc_cfinddialog.cpp
OBJMOC = .obj/moc_cmaindialog.o \
		.obj/moc_cfinddialog.o
DIST	   = unnamed.pro
QMAKE_TARGET = unnamed
DESTDIR  = 
TARGET   = unnamed

first: all
####### Implicit rules

.SUFFIXES: .c .o .cpp .cc .cxx .C

.cpp.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.cc.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.cxx.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.C.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.c.o:
	$(CC) -c $(CFLAGS) $(INCPATH) -o $@ $<

####### Build rules

all: Makefile $(TARGET)

$(TARGET):  $(UICDECLS) $(OBJECTS) $(OBJMOC)  
	$(LINK) $(LFLAGS) -o $(TARGET) $(OBJECTS) $(OBJMOC) $(OBJCOMP) $(LIBS)

mocables: $(SRCMOC)
uicables: $(UICDECLS) $(UICIMPLS)

$(MOC): 
	( cd $(QTDIR)/src/moc && $(MAKE) )

Makefile: unnamed.pro  /usr/lib/qt-3.3/mkspecs/default/qmake.conf /usr/lib/qt-3.3/lib/libqt-mt.prl
	$(QMAKE) -o Makefile unnamed.pro
qmake: 
	@$(QMAKE) -o Makefile unnamed.pro

dist: 
	@mkdir -p .obj/unnamed && $(COPY_FILE) --parents $(SOURCES) $(HEADERS) $(FORMS) $(DIST) .obj/unnamed/ && $(COPY_FILE) --parents cmaindialog.ui.h cfinddialog.ui.h .obj/unnamed/ && ( cd `dirname .obj/unnamed` && $(TAR) unnamed.tar unnamed && $(GZIP) unnamed.tar ) && $(MOVE) `dirname .obj/unnamed`/unnamed.tar.gz . && $(DEL_FILE) -r .obj/unnamed

mocclean:
	-$(DEL_FILE) $(OBJMOC)
	-$(DEL_FILE) $(SRCMOC)

uiclean:
	-$(DEL_FILE) $(UICIMPLS) $(UICDECLS)

yaccclean:
lexclean:
clean: mocclean uiclean
	-$(DEL_FILE) $(OBJECTS)
	-$(DEL_FILE) *~ core *.core


####### Sub-libraries

distclean: clean
	-$(DEL_FILE) $(TARGET) $(TARGET)


FORCE:

####### Compile

.obj/main.o: main.cpp .ui/cmaindialog.h \
		.ui/cfinddialog.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o .obj/main.o main.cpp

.ui/cmaindialog.h: cmaindialog.ui .ui/cfinddialog.h
	$(UIC) cmaindialog.ui -o .ui/cmaindialog.h

.ui/cmaindialog.cpp: .ui/cmaindialog.h cmaindialog.ui cmaindialog.ui.h .ui/cfinddialog.h
	$(UIC) cmaindialog.ui -i cmaindialog.h -o .ui/cmaindialog.cpp

.ui/cfinddialog.h: cfinddialog.ui 
	$(UIC) cfinddialog.ui -o .ui/cfinddialog.h

.ui/cfinddialog.cpp: .ui/cfinddialog.h cfinddialog.ui cfinddialog.ui.h 
	$(UIC) cfinddialog.ui -i cfinddialog.h -o .ui/cfinddialog.cpp

.obj/cmaindialog.o: .ui/cmaindialog.cpp cmaindialog.ui.h \
		.ui/cmaindialog.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o .obj/cmaindialog.o .ui/cmaindialog.cpp

.obj/cfinddialog.o: .ui/cfinddialog.cpp cfinddialog.ui.h \
		.ui/cfinddialog.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o .obj/cfinddialog.o .ui/cfinddialog.cpp

.obj/moc_cmaindialog.o: .moc/moc_cmaindialog.cpp  .ui/cmaindialog.h .ui/cfinddialog.h
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o .obj/moc_cmaindialog.o .moc/moc_cmaindialog.cpp

.obj/moc_cfinddialog.o: .moc/moc_cfinddialog.cpp  .ui/cfinddialog.h 
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o .obj/moc_cfinddialog.o .moc/moc_cfinddialog.cpp

.moc/moc_cmaindialog.cpp: $(MOC) .ui/cmaindialog.h
	$(MOC) .ui/cmaindialog.h -o .moc/moc_cmaindialog.cpp

.moc/moc_cfinddialog.cpp: $(MOC) .ui/cfinddialog.h
	$(MOC) .ui/cfinddialog.h -o .moc/moc_cfinddialog.cpp

####### Install

install:  

uninstall:  

