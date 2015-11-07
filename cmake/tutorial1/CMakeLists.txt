project(tutorial1)

cmake_minimum_required(VERSION 2.6)


set(CMAKE_MODULE_PATH ${tutorial1_SOURCE_DIR}/cmake/modules ${CMAKE_MODULE_PATH})

include(MacroOutOfSourceBuild)

macro_ensure_out_of_source_build("${PROJECT_NAME} requires an out of source build.")

add_subdirectory(src)
