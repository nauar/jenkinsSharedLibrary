/* Tags.groovy
 * 
 * Utils script for git tag management.
 * 
 */

public boolean existsTag(String repoURL, String tag) {
    return "1".equals(sh(returnStatus: true, "./search_tag.sh $repoURL $tag"))
}

