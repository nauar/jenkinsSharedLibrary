#!/bin/bash 

# This script is used for searching a tag in git. Parameters:
#
# GIT_REPO: Repository URL
# GIT_TAG:  Tag to look for

GITCMD="git"


function log() {
    moment=`date '+%d/%m/%Y %H:%M:%S'` 
    echo "[ $moment ] [ TAG_SEARCH ] $1"
}

function search() {
    GIT_REPO=$1
    GIT_TAG=$2
    log "Looking if tag ${GIT_TAG} exists in repo ${GIT_REPO}..."
    exists=$($GITCMD ls-remote --tags --refs ${GIT_REPO} | awk '{ print $2;}' | sed 's/refs\/tags\///g' | grep "^${GIT_TAG}$" | wc -l)
    if [ "$exists" -eq "1" ]; then
        log "Tag ${GIT_TAG} found in repo ${GIT_REPO}"
        return 1
    else
        log "Tag ${GIT_TAG} not found in repo ${GIT_REPO}"
        return 0
    fi
}

search $1 $2
