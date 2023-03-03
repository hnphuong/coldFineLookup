package hnp.selenium.chromedriver.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final int PAGING_STEP = 1;
    public static final String CTBERR400 = "CP400";
    public static final String CTBERR404 = "CP404";
    public static final String CTBERR401 = "CP401";
    public static final String RISKFREERATE = "RISKFREERATE";
    public static final String CTBERR403 = "CP403";
    public static final String RESOURCE_ORIGIN = "D:\\test_img\\###.png";
    public static final String RESOURCE_ORIGIN_SERVER = "/home/vehicle/Workspace/coldPenalty/capImages/###.png";
    public static final String RESOURCE_ORIGIN_CUT = "D:\\test_img\\###_cut.png";
    public static final String RESOURCE_TESSERACT = "/home/vehicle/Workspace/coldPenalty/install/tessdata";
    public static final String RESOURCE_TESSERACT_TEST = "D:\\test_img\\tesseract";
    public static final String RESOURCE_ORIGIN_CUT_SERVER = "/home/vehicle/Workspace/coldPenalty/capImages/###_cut.png";
    public static final String SEARCH_NOT_FOUND = "Không tìm thấy kết quả !";
    public static final String CAPTCHA_NOT_MATCH = "Mã xác nhận sai!";
    public static final String URL_BASE = "https://www.csgt.vn/tra-cuu-phuong-tien-vi-pham.html";
    public static final String URL_BASE_MOBILE = "https://www.csgt.vn/m/tra-cuu-phuong-tien-vi-pham.html";

    public static final String LICENSE_PLATES = "Biển kiểm soát";
    public static final String LICENSE_PLATES_COLOR = "Màu biển";
    public static final String TYPE_VEHICLE = "Loại phương tiện";
    public static final String VIOLATION_TIME = "Thời gian vi phạm";
    public static final String VIOLATION_LOCATION = "Địa điểm vi phạm";
    public static final String VIOLATION = "Hành vi vi phạm";
    public static final String STATUS = "Trạng thái";
    public static final String VIOLATION_DETECTION_UNIT = "Đơn vị phát hiện vi phạm";
    public static final String PLACE_TO_SOLVE = "Nơi giải quyết vụ việc";

    public static final String HTML5 = "<html><head><title>First parse</title></head>"
            + "<body>###</body></html>";
    public static final String DATA = "<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30A-119.68</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">08:13, 09/05/2022</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Hành vi vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Không chấp hành hiệu lệnh của đèn tín hiệu giao thông</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "           <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: 54 Trần Hưng Đạo - Hoàn Kiếm - Hà Nội</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 0692196440</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30A-119.68</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">07:27, 15/04/2022</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Hành vi vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Không chấp hành hiệu lệnh của đèn tín hiệu giao thông</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "           <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: 54 Trần Hưng Đạo - Hoàn Kiếm - Hà Nội</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 0692196440</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30A-119.68</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">16:39, 02/11/2022</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Võ Chí Công - Nguyễn Hoàng Tôn\tTây Hồ, Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Hành vi vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Không chấp hành hiệu lệnh của đèn tín hiệu giao thông</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "           <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội CHGT và điều khiển Đèn tín hiệu, Công an  Hà Nội</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: 54 Trần Hưng Đạo - Hoàn Kiếm - Hà Nội</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 0692196440</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">";
}
