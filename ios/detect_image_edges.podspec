#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint edge_detection.podspec` to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'detect_image_edges'
  s.version          = '1.0.1'
  s.summary          = 'Plugin to detect edges of objects'
  s.description      = <<-DESC
Plugin to detect edges of objects
                       DESC
  s.homepage         = 'https://github.com/muneerradwan-manager/detect_image_edges'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Name' => 'your.email@example.com' }
  s.resources        = 'Assets/**/*'
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.dependency 'WeScan'
  s.platform = :ios, '13.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
  s.swift_version = '5.0'
end
