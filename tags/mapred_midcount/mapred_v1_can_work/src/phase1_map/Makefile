# weizili@360.cn 

CC=gcc
CXX=g++
AR=ar
ARFLAGS=cru

CURRENT_DIR=$(shell echo `pwd`)
QMODULE=${CURRENT_DIR}/..
COMMONFLAGS=-g -fPIC -Wshadow -Wcast-qual -Wcast-align -Wwrite-strings -Wsign-compare -Winvalid-pch -fms-extensions -Wfloat-equal -Wextra -Wall -Wno-unused-parameter -Wno-unused-function -Wunused-variable -Wunused-value -I$(QMODULE)/include -I/usr/local/include -I.. -I. -I include $(QMODULE)/include
CFLAGS=$(COMMONFLAGS)
CCFLAGS=-Woverloaded-virtual -Wsign-promo -fno-gnu-keywords $(COMMONFLAGS) 
LDFLAGS=-L $(QMODULE)/lib -L/usr/local/lib $(QMODULE)/lib/libgflags.a $(QMODULE)/lib/libqlog.a $(QMODULE)/lib/libqoslib.a $(QMODULE)/lib/libidea.a -lstdc++
TARGET := $(shell basename `pwd`)
PREFIX=../../bin

SRCS := $(wildcard *.cc)
OBJS := $(patsubst %.cc, %.o, $(SRCS))

UNITTEST_SRC = $(wildcard ut/*.cc)
UNITTEST_OBJ = $(patsubst %.cc, %.o, $(UNITTEST_SRC)) $(filter-out main.o,$(OBJS))
UNITTEST_CFLAGS = -D_DEBUG
UNITTEST_LDFLAGS = -L$(QMODULE)/lib
UNITTEST_LIBS= -lcppunit -lboost_filesystem
UNITTEST_TARGET=unittest 


all : $(OBJS) $(TARGET) 
	$(MAKE) install
t :
	@echo $(CURRENT_DIR)
	@echo $(QMODULE)
	@echo $(TARGET)
	@echo $(OBJS)
	@echo $(UNITTEST_OBJ)

test: $(UNITTEST_TARGET)

check: $(UNITTEST_TARGET)
	./unittest

$(UNITTEST_TARGET): $(UNITTEST_OBJ) $(TARGET) 
	$(CXX) $(UNITTEST_OBJ) $(LDFLAGS) $(UNITTEST_LDFLAGS) $(UNITTEST_LIBS) -o $(UNITTEST_TARGET)

$(TEST_DATA_BUILDER) : $(TEST_DATA_BUILDER_OBJS)
	$(CC) $(TEST_DATA_BUILDER_OBJS) $(LDFLAGS) -o $@

$(PROTOBUF_PERFORMANCE_TEST) : $(PROTOBUF_PERFORMANCE_TEST_OBJS)
	$(CC) $^ $(LDFLAGS) -o $@

$(TARGET) : $(OBJS)
	$(CC) $^ $(LDFLAGS) -o $@

install: $(TARGET)
	@cp -f $(TARGET) $(PREFIX)

%.o : %.cc %.h
	$(CXX) -c $(CFLAGS) $(CCFLAGS) $< -o $@

%.o : %.cc 
	$(CXX) -c $(CFLAGS) $(CCFLAGS) $< -o $@

ut/%.o : ut/%.cc
	$(CXX) -c $(UNITTEST_CFLAGS) $(CFLAGS) $(CCFLAGS) -o $@ $<

clean:
	rm -rf *.o ut/*.o $(TARGET) 

distclean:
	$(MAKE) clean
	rm -rf *.o $(TARGET) $(TEST_DATA_BUILDER) $(PROTOBUF_PERFORMANCE_TEST) $(UNITTEST_TARGET)

